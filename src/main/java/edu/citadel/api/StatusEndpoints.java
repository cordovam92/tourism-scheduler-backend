package edu.citadel.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import edu.citadel.dal.PersonRepository;
import edu.citadel.dal.PlayerRepository;
import edu.citadel.dal.model.Person;
import edu.citadel.dal.model.Players;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Endpoint for determining the status and API information. These endpoints are not included
 * within the FHIR Swagger
 */
@RestController
@RequestMapping("/")
public class StatusEndpoints {

    @Value("${info.app.name}")
    private String applicationName;

    @Value("${info.app.description}")
    private String applicationDescription;

    @Value("${info.app.version}")
    private String applicationVersion;

    private final PersonRepository personRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public StatusEndpoints(@NonNull PersonRepository personRepository, @NonNull PlayerRepository playerRepository) {
        this.personRepository = personRepository;
        this.playerRepository = playerRepository;
    }

    private final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @GetMapping(value = "health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() throws JsonProcessingException {
        Map<String, String> healthStatus = new HashMap<>();
        healthStatus.put("status", "ok");
        return objectWriter.writeValueAsString(healthStatus);
    }

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String info() throws JsonProcessingException {
        Map<String, String> info = new HashMap<>();
        info.put("name", applicationName);
        info.put("version", applicationVersion);
        info.put("description", applicationDescription);
        return objectWriter.writeValueAsString(info);
    }

    @PostMapping(value = "/whatsapp/send")
    @ApiOperation(value = "Sends data to Whatsapp via Twillio", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource was not found"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Cannot process request")
    }
    )
    public Message sendViaWhatsapp(@ApiParam(name = "simpleObject", value = "Simple object", required = true)
                                      @RequestBody LinkedHashMap<String,String> hashMap) {
        Twilio.init("AC584111c88984637ad7e0aaa497b292e3", "e2148e3d2e2adb0e2b1c0be24e4894f6");
        return Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+1" + hashMap.get("phoneNumber")),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                hashMap.get("message"))
                .create();
    }

    @PostMapping(value = "/person")
    @ApiOperation(value = "Creates a person object", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource was not found"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Cannot process request")
    }
    )
    public String createAPerson(@ApiParam(name = "simpleObject", value = "Simple object", required = true)
                                   @RequestBody LinkedHashMap<String,String> hashMap) throws JsonProcessingException {

        Person person = new Person();
        person.setDob(hashMap.get("dob"));
        person.setGender(hashMap.get("gender"));
        person.setFirstName(hashMap.get("firstName"));
        person.setLastName(hashMap.get("lastName"));
        person.setSsn(hashMap.get("ssn"));

        Person p = personRepository.save(person);

        Map<String, String> info = new HashMap<>();
        info.put("personId", p.getId().toString());
        return objectWriter.writeValueAsString(info);
    }

    @PostMapping(value = "/players")
    @ApiOperation(value = "Creates a player object", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource was not found"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Cannot process request")
    }
    )
    public String createAPlayer(@ApiParam(name = "simpleObject", value = "Simple object", required = true)
                                @RequestBody LinkedHashMap<String,String> hashMap) throws JsonProcessingException {

        Players player = new Players();
        player.setFirstName(hashMap.get("firstName"));
        player.setLastName(hashMap.get("lastName"));
        player.setTeam(hashMap.get("team"));
        player.setPosition(hashMap.get("position"));
        player.setGamesPlayed(Integer.parseInt(hashMap.get("gamesPlayed")));

        Players p = playerRepository.save(player);

        Map<String, String> info = new HashMap<>();
        info.put("playerId", p.getId().toString());
        return objectWriter.writeValueAsString(info);
    }

    @GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getPerson(@PathVariable String id) throws JsonProcessingException {

        Long idLong = Long.parseLong(id);
        Person person = personRepository.findById(idLong).orElse(null);

        if (person != null) {
            Map<String, String> personMap = new HashMap<>();
            personMap.put("firstName", person.getFirstName());
            personMap.put("lastName", person.getLastName());
            personMap.put("dob", person.getDob());
            personMap.put("ssn", person.getSsn());
            personMap.put("gender", person.getGender());
            return ResponseEntity.status(HttpStatus.OK).body(objectWriter.writeValueAsString(personMap));
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("message", "Person not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(objectWriter.writeValueAsString(errorMessage));
        }
    }
}



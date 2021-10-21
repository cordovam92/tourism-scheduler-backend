package edu.citadel.fhirvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot entry point for the FHIR Validator API Application
 */
@EnableJpaRepositories("edu.citadel.dal")
@EntityScan("edu.citadel.dal.model")
@ComponentScan(value = {"edu.citadel"})
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}


package edu.citadel.dal;

import edu.citadel.dal.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassingRepository extends CrudRepository<Person, Long> {
}

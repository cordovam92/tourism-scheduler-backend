package edu.citadel.dal;

import edu.citadel.dal.model.Receiving;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingRepository extends CrudRepository<Receiving, Long> {
}

package edu.citadel.dal;

import edu.citadel.dal.model.Place;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
//public interface PlaceRepository extends CrudRepository<Place, Integer>{
//}

public interface PlaceRepository extends JpaRepository<Place, Integer>{
    //custom query to search by type and subtype
    @Query(
            value = "SELECT * FROM tourism p WHERE p.type = ?1 AND p.subtype = ?2",
            nativeQuery = true)
    List<Place> findByTypeContainingOrSubtypeContaining(String type, String subtype);

    //custom query to search by type
    @Query(
            value = "SELECT * FROM tourism p WHERE p.type = ?1",
            nativeQuery = true)
    List<Place> findByTypeContaining(String type);
}

package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Campus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//public interface CampusMongoRepository extends MongoRepository<Campus, String> {
//    public Campus findByName(String name);
//
//    public Campus findByTrainingManagerId(Integer id);
//
//    public Campus findByStagingManagerId(Integer id);
//}
@Repository
public interface CampusRepository extends CrudRepository<Campus, Integer> {
    Campus findByName(String name);

    Campus findByTrainingManagerId(Integer id);

    Campus findByStagingManagerId(Integer id);
}
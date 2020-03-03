package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Campus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampusMongoRepository extends MongoRepository<Campus, Integer> {

}

package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingMongoRepository extends MongoRepository<Building, Integer> {
}

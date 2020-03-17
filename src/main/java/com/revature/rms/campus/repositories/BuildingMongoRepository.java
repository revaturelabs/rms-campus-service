package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Building;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface BuildingMongoRepository extends MongoRepository<Building, String> {
    public Building findByName(String name);

    public Building findByTrainingLead(Integer id);
}


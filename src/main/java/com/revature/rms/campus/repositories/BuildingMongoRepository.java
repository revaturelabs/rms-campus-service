package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BuildingMongoRepository extends MongoRepository<Building, Integer> {
    public Optional<Building> findById(Integer id);

    public Building findByName(String name);
}
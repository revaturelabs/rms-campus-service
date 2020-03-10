package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    private BuildingMongoRepository buildingMongoRepository;

    @Autowired
    public BuildingService(BuildingMongoRepository buildingMongoRepository) {
        this.buildingMongoRepository = buildingMongoRepository;
    }


    public Building save(Building building) {
        return buildingMongoRepository.save(building);
    }

    public List<Building> findAll() {
        return buildingMongoRepository.findAll();
    }

    public Optional<Building> findById(String id) {
        return buildingMongoRepository.findById(id);
    }

    public Building findByName(String name) {
        return buildingMongoRepository.findByName(name);
    }



    public Building update(Building building) {
        return buildingMongoRepository.save(building);
    }

    public void delete(String id) {
       buildingMongoRepository.deleteById(id);
    }
}

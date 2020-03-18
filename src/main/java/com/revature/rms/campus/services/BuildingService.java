package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.exceptions.ResourcePersistenceException;
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

    /**
     * Save Method: Takes in a building object as the input. The input room
     * object is tested to ensure that it is not null. If the room object
     * is null then it will throw a ResourceNotFoundException.
     * Once the room object passes the test it is then saved or persisted
     * to the database.
     * @param building
     * @return The new saved room object
     */

    public Building save(Building building) {

        if (building == null) {
            throw new ResourcePersistenceException();
        }
        return buildingMongoRepository.save(building);
    }

    /**
     * findAll method: returns a list of all the building objects in the database.
     * @return a list of all the buildings
     */
    public List<Building> findAll() {
        return buildingMongoRepository.findAll();
    }

    /**
     * findByBuilding Method: This takes in the id as the input
     * parameter. The input room number is validated to ensure that it is not
     * empty or negative or zero. If the id fails this validation an
     * InvalidInputException is thrown.
     * The building object with the specified building number is retrieved. The building
     * object is tested to ensure that the building object is present. If the building
     * object is not present then a ResourceNotFoundException is thrown.
     * If all these validations are passed, the building object that have the specified
     * building number is returned.
     * @param id
     * @return the building object with the same room number as the input parameter.
     */

    public Optional<Building> findById(String id) {
        if (id.isEmpty() || (Integer.parseInt(id) <= 0)) {
            throw new InvalidInputException();
        }
        Optional<Building> theBuilding = buildingMongoRepository.findById(id);
         if (!theBuilding.isPresent()) {
            throw new  ResourceNotFoundException();
        }

        return buildingMongoRepository.findById(id);
    }

    /**
     * findByNameMethod: This takes in the building name as the input
     * parameter.
     * @param name
     * @return the room object with the same room number as the input parameter.
     */
    public Building findByName(String name) {
        return buildingMongoRepository.findByName(name);
    }


    /**
     * Update Method: The building object is inputted and changes are saved.
     * The modified object is returned.
     * @param building
     * @return Updated/Modified room object
     */
    public Building update(Building building) {
        return buildingMongoRepository.save(building);
    }


    /**
     * Delete Method: Building object is found by id and deleted
     * The method takes in the building id. The input is tested to ensure
     * that it is not empty, negative or zero. if the input is empty,
     * negative or zero, an InvalidInputException is thrown.
     * If the building id exist, the object is then deleted
     * @param id
     * @return The deleted building object.
     */

    public void delete(String id) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
       buildingMongoRepository.deleteById(id);
    }

    /**
     * findByTrainingLeadId Method: Building object is found by the training lead id
     * The method takes in the training lead id. The input is tested to ensure
     * that it is not empty, negative or zero. if the input is empty,
     * negative or zero, an InvalidInputException is thrown.
     * If the training lead id exist, the building object is returned
     * @param id
     * @return The building object object.
     */

    public Building findByTrainingLeadId(Integer id) {
        if (id < 1) throw new InvalidInputException();
        Building temp = buildingMongoRepository.findByTrainingLead(id);
        if( temp == null) throw new ResourceNotFoundException();
        else return temp;
    }
}

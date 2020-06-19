package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.exceptions.ResourcePersistenceException;
//import com.revature.rms.campus.repositories.BuildingMongoRepository;
import com.revature.rms.campus.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The methods in this service call to methods from the buildingRepository in order to give the basic CRUD features to
 * the application. The methods in this service are custom as a result of TDD. For more information about the testing
 * see BuildingServiceTests.
 */
@Service
public class BuildingService {

    private BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    /**
     * Save Method: Takes in a building object as the input. The input room
     * object is tested to ensure that it is not null. If the building object
     * is null then it will throw a ResourceNotFoundException.
     * Once the building object passes the test it is then saved or persisted
     * to the database.
     *
     * @param building
     * @return The new saved building object
     */
    @Transactional
    public Building save(Building building) {

        if (building == null) {
            throw new ResourcePersistenceException();
        }
        return buildingRepository.save(building);
    }

    /**
     * findAll method: returns a list of all the building objects in the database.
     *
     * @return a list of all the buildings
     */
    @Transactional(readOnly = true)
    public List<Building> findAll() {
        Iterable<Building> b = buildingRepository.findAll();
        List<Building> list = getListFromIterator(b);
        return list;
    }

    /**
     * findById Method: This takes in the id as the input
     * parameter. The input room number is validated to ensure that it is not
     * empty or negative or zero. If the id fails this validation an
     * InvalidInputException is thrown.
     * The building object with the specified building number is retrieved. The building
     * object is tested to ensure that the building object is present. If the building
     * object is not present then a ResourceNotFoundException is thrown.
     * If all these validations are passed, the building object that have the specified
     * building number is returned.
     *
     * @param id
     * @return the building object with the same building id as the input parameter.
     */
    @Transactional(readOnly = true)
    public Optional<Building> findById(int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Optional<Building> theBuilding = buildingRepository.findById(id);
        if (!theBuilding.isPresent()) {
            throw new ResourceNotFoundException();
        }

        return buildingRepository.findById(id);
    }

    /**
     * findByName Method: This takes in the building name as the input
     * parameter.
     *
     * @param name
     * @return the room object with the same room number as the input parameter.
     */
    @Transactional(readOnly = true)
    public Building findByName(String name) {
        return buildingRepository.findByName(name);
    }


    /**
     * Update Method: The building object is inputted and changes are saved.
     * The modified object is returned.
     *
     * @param building
     * @return Updated/Modified room object
     */
    @Transactional
    public Building update(Building building) {
        return buildingRepository.save(building);
    }

    /**
     * Delete Method: Building object is found by id and deleted
     * The method takes in the building id. The input is tested to ensure
     * that it is not empty, negative or zero. if the input is empty,
     * negative or zero, an InvalidInputException is thrown.
     * If the building id exist, the object is then deleted
     *
     * @param id
     * @return The deleted building object.
     */
    @Transactional
    public void delete(int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        buildingRepository.deleteById(id);
    }

    /**
     * findByTrainingLeadId Method: Building object is found by the training lead id
     * The method takes in the training lead id. The input is tested to ensure
     * that it is not empty, negative or zero. if the input is empty,
     * negative or zero, an InvalidInputException is thrown.
     * If the training lead id exist, the building object is returned
     *
     * @param id
     * @return The building object.
     */
    @Transactional(readOnly = true)
    public Building findByTrainingLeadId(int id) {
        if (id < 1) throw new InvalidInputException();
        Building temp = buildingRepository.findByTrainingLead(id);
        if (temp == null) throw new ResourceNotFoundException();
        else return temp;
    }

    /**
     * getListFromIterator Method: Is a custom method that iterates and adds each object to a list of the specified Generic.
     * @param iterable an Iterable that wants to be converted into an ArrayList
     * @param <T> Generic of any ObjectType
     * @return Returns a List of type T
     */
    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}

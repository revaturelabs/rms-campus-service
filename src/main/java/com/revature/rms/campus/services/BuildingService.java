package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    @Autowired
    private BuildingMongoRepository buildingMongoRepository;

//    public Building create(String name, String abbrName,
//                           Address physicalAddress, Integer trainingLead, ArrayList<Amenity> amenities,
//                           ArrayList<Room> rooms, ResourceMetadata resourceMetaData) {
//        return buildingMongoRepository.save(new Building(name, abbrName, physicalAddress,
//                trainingLead, amenities, rooms, resourceMetaData));
//    }

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

//    public Building update(String name, String abbrName,
//                           Address physicalAddress, Integer trainingLead, ArrayList<Amenity> amenities,
//                           ArrayList<Room> rooms, ResourceMetadata resourceMetaData) {
//        Building building = buildingMongoRepository.findByName(name);
//        building.setName(name);
//        building.setAbbrName(abbrName);
//        building.setPhysicalAddress(physicalAddress);
//        building.setTrainingLead(trainingLead);
//        building.setAmenities(amenities);
//        building.setRooms(rooms);
//        building.setResourceMetaData(resourceMetaData);
//        return buildingMongoRepository.save(building);
//    }

    public Building update(Building building) {
        return buildingMongoRepository.save(building);
    }

    public void delete(String Id) {
        Building building = buildingMongoRepository.findById(Id).get();
        buildingMongoRepository.delete(building);
    }
}

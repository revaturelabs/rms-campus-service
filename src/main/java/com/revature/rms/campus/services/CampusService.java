package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.repositories.BuildingMongoRepository;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService {

    @Autowired
    private CampusMongoRepository campusMongoRepository;

    public Campus save(Campus campus) {
        return campusMongoRepository.save(campus);
    }

    public List<Campus> findAll() {
        return campusMongoRepository.findAll();
    }

    public Optional<Campus> findById(String id) {
        return campusMongoRepository.findById(id);
    }

    public Campus findByName(String name) {
        return campusMongoRepository.findByName(name);
    }

    public Campus update(Campus campus) {
        return campusMongoRepository.save(campus);
    }

    public void delete(String id) {
        campusMongoRepository.deleteById(id);
    }
}

package com.revature.rms.campus.services;


import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampusService {

    private CampusMongoRepository campusMongoRepository;

    @Autowired
    public CampusService(CampusMongoRepository repo) {
        this.campusMongoRepository = repo;
    }

    public Campus save(Campus campus) {
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campusMongoRepository.save(campus);
    }


    public List<Campus> findAll() {
        return campusMongoRepository.findAll();
    }

    public Optional<Campus> findById(String id) {
        if (id.isEmpty() || (Integer.parseInt(id) <= 0)) {
            throw new InvalidInputException();
        }
        Optional<Campus> _campus = campusMongoRepository.findById(id);
        if (!_campus.isPresent()) {
            throw new  ResourceNotFoundException();
        }
        return _campus;
    }

    public Campus findByTrainingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
        Campus campus = campusMongoRepository.findByTrainingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

    public Campus findByStagingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
        Campus campus = campusMongoRepository.findByStagingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

    public Campus findByName(String name) {
        return campusMongoRepository.findByName(name);
    }

    public Campus update(Campus campus) {
        return campusMongoRepository.save(campus);
    }

    public void delete(String id) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        campusMongoRepository.deleteById(id);
    }
}

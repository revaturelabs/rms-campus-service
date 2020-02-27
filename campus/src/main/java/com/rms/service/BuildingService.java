package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.BuildingDao;
import com.rms.model.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    
    @Autowired
    BuildingDao bd;

    public void save(Building build) {
        bd.save(build);
    }

    public void delete(Building build) {
        bd.delete(build);
    }

    public void update(Building build) {
        bd.save(build);
    }

    public Optional<Building> findById(int id) {
        return bd.findById(id);
    }

    public List<Building> findAll() {
        return (List<Building>) bd.findAll();
    }


}
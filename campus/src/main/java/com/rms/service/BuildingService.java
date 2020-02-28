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
    BuildingDao bl;

    public void saveOrUpdate(Building bld) {
        bl.save(bld);
    }

    public void delete(Building bld) {
        bl.delete(bld);
    }

    public Optional<Building> read(int id) {
        return bl.findById(id);
    }

    public List<Building> readAll() {
        return (List<Building>) bl.findAll();
    }
}
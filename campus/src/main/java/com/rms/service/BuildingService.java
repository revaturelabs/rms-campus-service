package com.rms.service;

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
}
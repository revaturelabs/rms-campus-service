package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.AmenityDao;
import com.rms.model.Amenity;

import org.springframework.beans.factory.annotation.Autowired;

public class AmenityService {
    
    @Autowired
    AmenityDao am;

    public void saveOrUpdate(Amenity amen) {
        am.save(amen);
    }

    public void delete(Amenity amen) {
        am.delete(amen);
    }

    public Optional<Amenity> read(int id) {
        return am.findById(id);
    }

    public List<Amenity> readAll() {
        return (List<Amenity>) am.findAll();
    }
}
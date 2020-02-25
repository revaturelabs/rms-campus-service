package com.rms.dao;

import com.rms.model.Amenity;

import org.springframework.data.repository.CrudRepository;

public interface AmenityDao extends CrudRepository<Amenity, Integer>{
    
}
package com.rms.dao;

import com.rms.model.Amenity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AmenityDao extends CrudRepository<Amenity, Integer>{
    
}
package com.rms.dao;

import com.rms.model.Campus;

import org.springframework.data.repository.CrudRepository;

public interface CampusDao extends CrudRepository<Campus, Integer>{
    
}
package com.rms.dao;


import com.rms.model.Campus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CampusDao extends CrudRepository<Campus, Integer>{
    
}
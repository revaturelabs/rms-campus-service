package com.revature.rms.campus.services;

import com.revature.rms.campus.repositories.CampusMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    public CampusMongoRepository cMongoRepo;

    @Autowired
    public CampusService (CampusMongoRepository repo) {
        super();
        this.cMongoRepo = repo;
    }

    
}

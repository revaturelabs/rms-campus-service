package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.repos.BuildingRepository;
import com.revature.rms.core.services.ResourceService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BuildingService extends ResourceService<Building> {

    public BuildingService(BuildingRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

}

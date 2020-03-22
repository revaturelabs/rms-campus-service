package com.revature.rms.campus.services;

import com.revature.rms.campus.documents.Campus;
import com.revature.rms.campus.repos.CampusRepository;
import com.revature.rms.core.services.ResourceService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CampusService extends ResourceService<Campus> {

    public CampusService(CampusRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

}

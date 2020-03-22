package com.revature.rms.campus.services;

import com.revature.rms.campus.documents.Room;
import com.revature.rms.campus.repos.RoomRepository;
import com.revature.rms.core.services.ResourceService;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends ResourceService<Room> {

    public RoomService(RoomRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

}

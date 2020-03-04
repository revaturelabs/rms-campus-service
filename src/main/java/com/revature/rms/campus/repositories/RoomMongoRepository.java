package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomMongoRepository extends MongoRepository<Room, Integer> {

}

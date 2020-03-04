package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.RoomStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomStatusMongoRepository extends MongoRepository<RoomStatus, String> {
}

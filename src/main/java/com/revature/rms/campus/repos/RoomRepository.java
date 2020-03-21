package com.revature.rms.campus.repos;

import com.revature.rms.campus.entities.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
}

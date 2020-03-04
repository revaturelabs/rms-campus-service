package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomMongoRepository extends MongoRepository<Room, String> {
    public Optional<Room> findByRoomNumber(String name);
}

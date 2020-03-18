package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoomMongoRepository extends MongoRepository<Room, String> {
    public Optional<Room> findByRoomNumber(String name);

    //public List<Room> findByActiveRooms(boolean active);

    public List<Room> findByMaxOccupancy(int occupancy);

}

package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoomMongoRepository extends MongoRepository<Room, String> {
    public Optional<Room> findByRoomNumber(String name);

    /**
     * findByActiveRooms: The active parameter is passed as the input.
     * A list of active rooms are returned when input is true and a list
     * of inactive rooms are returned when input is false.
     * @param
     * @return list of all the rooms with the given active parameter
     */
     // public List<Room> findByActiveRooms(boolean active);


    public List<Room> findByMaxOccupancy(int occupancy);

}

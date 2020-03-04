package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.RoomStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomStatusMongoRepository extends MongoRepository<RoomStatus, Integer> {

    public List<RoomStatus> findAllBySubmitterId(int submitterId);
}

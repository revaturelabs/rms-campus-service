package com.revature.rms.campus.repositories;

import com.revature.rms.campus.entities.RoomStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface RoomStatusMongoRepository extends MongoRepository<RoomStatus, String> {
//    public List<RoomStatus> findAllBySubmitterId(int submitterId);
//
//    public List<RoomStatus> findByArchivedIsTrue(boolean archived);
//
//    public List<RoomStatus> findAllBySubmittedDateTime(String date);
//}

public interface RoomStatusRepository extends CrudRepository<RoomStatus, Integer> {
    List<RoomStatus> findAllBySubmitterId(int submitterId);

    List<RoomStatus> findByArchivedIsTrue(boolean archived);

    List<RoomStatus> findAllBySubmittedDateTime(String date);
}
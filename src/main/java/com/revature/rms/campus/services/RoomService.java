package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.entities.RoomStatus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.RoomMongoRepository;
import com.revature.rms.campus.repositories.RoomStatusMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomMongoRepository roomMongoRepository;

    @Autowired
    private RoomStatusMongoRepository roomStatusRepo;


    public List<Room> findAll(){ return roomMongoRepository.findAll();
    }
    public Optional<Room> findByRoomNumber(String roomNum){
        if (roomNum.isEmpty() || (Integer.parseInt(roomNum) <= 0)) {
            throw new InvalidInputException();
        }
        Optional<Room> _room = roomMongoRepository.findByRoomNumber(roomNum);

        if(!_room.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return _room;
    }
    public Optional<Room> findById(String id){
        if (id.isEmpty() || (Integer.parseInt(id) <= 0)) {
            throw new InvalidInputException();
        }
        Optional<Room> _room = roomMongoRepository.findById(id);
        if(!_room.isPresent()){
            throw new ResourceNotFoundException();
        }
        return _room;
    }

//    public List<Room> findAllActiveRooms(boolean active){
//        return roomMongoRepository.findByActiveRooms(active);
//    }

    public List<Room> findByMaxOccupancy(int occupancy){
        return roomMongoRepository.findByMaxOccupancy(occupancy);
    }

    public Room save(Room room){
        if(room == null){
            throw new ResourceNotFoundException();
        }
        return roomMongoRepository.save(room);}

    public Room update(Room room){return roomMongoRepository.save(room);}

    //Soft Delete Method: Updates the room object
    //Sets active to false to indicate room no longer available
    //Soft delete is implemented in the event of auditing.
    //May need some modifications to pass testing.
    public Room delete(String id){
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        Room deleteRoom = roomMongoRepository.findById(id).get();
        deleteRoom.setActive(false);
        return update(deleteRoom);
    }

    public List<RoomStatus> findAllStatusBySubmitter(int id){
        return roomStatusRepo.findAllBySubmitterId(id);
    }

    public List<RoomStatus> findAllStatusByDate(String date){ return roomStatusRepo.findAllBySubmittedDateTime(date);}

    public Optional<RoomStatus> findStatusById(String id){
        return roomStatusRepo.findById(id);
    }

    public List<RoomStatus> findAllStatus(){
        return roomStatusRepo.findAll();
    }

    public List<RoomStatus> findAllByArchive(boolean active){
        return roomStatusRepo.findByArchivedIsTrue(active);
    }

    public void saveStatus(RoomStatus roomStatus){
        roomStatusRepo.save(roomStatus);
    }

    public RoomStatus updateStatus(RoomStatus roomStatus){
        return roomStatusRepo.save(roomStatus);
    }

    //soft delete
    public void deleteRoomStatus(String statusId){
        RoomStatus deleteStatus = roomStatusRepo.findById(statusId).get();
        deleteStatus.setArchived(true);
        saveStatus(deleteStatus);
    }

}

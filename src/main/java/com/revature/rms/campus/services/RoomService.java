package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.entities.RoomStatus;
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
    public Optional<Room> findByRoomNumber(String roomNum){return roomMongoRepository.findByRoomNumber(roomNum);}

    public Optional<Room> findById(String id){
        return roomMongoRepository.findById(id);
    }

    public List<Room> findAllActiveRooms(boolean active){
        return roomMongoRepository.findAllActive(active);
    }

    public List<Room> findByMaxOccupants(int occupancy){
        return roomMongoRepository.findByMaxOccupancy(occupancy);
    }

    public Room save(Room room){return roomMongoRepository.save(room);}

    public Room update(Room room){return roomMongoRepository.save(room);}

    //soft delete
    public void delete(String id){
        Room deleteRoom = roomMongoRepository.findByRoomNumber(id).get();
        deleteRoom.setIsActive(false);
        save(deleteRoom);
    }

    public List<RoomStatus> findAllStatusBySubmitter(int id){
        return roomStatusRepo.findAllBySubmitterId(id);
    }

    public List<RoomStatus> findAllStatusByDate(String date){ return roomStatusRepo.findAllBySubmittedDate(date);}

    public Optional<RoomStatus> findStatusById(String id){
        return roomStatusRepo.findById(id);
    }

    public List<RoomStatus> findAllStatus(){
        return roomStatusRepo.findAll();
    }

    public List<RoomStatus> findAllByArchive(boolean active){
        return roomStatusRepo.findAllActive(active);
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

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

    public Optional<Room> findById(int id){
        return roomMongoRepository.findById(id);
    }

    public void save (Room room){
        roomMongoRepository.save(room);
    }



    // Change to soft delete?
    public void delete(int id){
        roomMongoRepository.deleteById(id);
    }

    public List<RoomStatus>findAllStatus(int id){
        return roomStatusRepo.findAllBySubmitterId(id);
    }

    public Optional<RoomStatus> findStatusById(int id){
        return roomStatusRepo.findById(id);
    }

    public List<RoomStatus> findAllStatus(){
        return roomStatusRepo.findAll();
    }

    public void saveStatus(RoomStatus roomStatus){
        roomStatusRepo.save(roomStatus);
    }
}

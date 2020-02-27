package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.RoomDao;
import com.rms.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    
    @Autowired
    RoomDao rd;

    public void save(Room rm) {
        rd.save(rm);
    }

    public void delete(Room rm) {
        rd.delete(rm);
    }

    public void update(Room rm) {
        rd.save(rm);
    }

    public Optional<Room> findById(int id){
        return rd.findById(id);
    }

    public List<Room> findAll() {
        return(List<Room>) rd.findAll();
    }
}
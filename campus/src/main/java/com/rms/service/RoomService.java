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

    public void saveOrUpdate(Room room) {
        rd.save(room);
    }

    public void delete(Room room) {
        rd.delete(room);
    }

    public Optional<Room> read(int id) {
        return rd.findById(id);
    }

    public List<Room> readAll() {
        return (List<Room>) rd.findAll();
    }
}
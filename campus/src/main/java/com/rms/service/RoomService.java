package com.rms.service;

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
}
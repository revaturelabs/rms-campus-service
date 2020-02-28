package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.RoomStatusDao;
import com.rms.model.RoomStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {
    
    @Autowired
    RoomStatusDao rsd;

    public void saveOrUpdate(RoomStatus status) {
        rsd.save(status);
    }

    public void delete(RoomStatus status) {
        rsd.delete(status);
    }

    public Optional<RoomStatus> read(int id) {
        return rsd.findById(id);
    }

    public List<RoomStatus> readAll() {
        return (List<RoomStatus>) rsd.findAll();
    }
}
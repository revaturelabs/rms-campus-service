package com.rms.service;

import com.rms.dao.RoomStatusDao;
import com.rms.model.RoomStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {
    
    @Autowired
    RoomStatusDao rsd;

    public void save(RoomStatus rms) {
        rsd.save(rms);
    }

    public void delete(RoomStatus rms){
        rsd.delete(rms);
    }
}
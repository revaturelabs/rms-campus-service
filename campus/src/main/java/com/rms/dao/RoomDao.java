package com.rms.dao;

import com.rms.model.Room;

import org.springframework.data.repository.CrudRepository;

public interface RoomDao extends CrudRepository<Room, Integer>{
    
}
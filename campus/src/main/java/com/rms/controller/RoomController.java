package com.rms.controller;

import com.rms.dao.RoomDao;
import com.rms.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    
    @Autowired
    RoomDao rd;

    @GetMapping("/id")
    public Room findById(@PathVariable("id") int id){
        return rd.findById(id).get();
    }

    public String insert(@RequestBody Room r){
        rd.save(r);
        return "Room has been added or updated";
    }
}
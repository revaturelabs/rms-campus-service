package com.rms.controller;

import com.rms.dao.RoomDao;
import com.rms.model.Room;
import com.rms.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    
    @Autowired
    RoomDao rs;

    @GetMapping("/{id}")
    public Room findById(@PathVariable("id") int id){
        return rs.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Room> getAllRooms() {
        return rs.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Room r){
        rs.save(r);
        return "Room has been added";
    }

    @PutMapping("/updated")
    public Room update(@RequestBody Room r){
        return rs.save(r);
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Room r) {
        rs.delete(r);
        return "Room has been deleted";
    }

}
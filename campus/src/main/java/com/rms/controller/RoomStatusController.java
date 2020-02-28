package com.rms.controller;

import com.rms.dao.RoomStatusDao;
import com.rms.model.RoomStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomStatusController {

    @Autowired
    RoomStatusService rsd;

    @GetMapping("/{id}")
    public RoomStatus findById(@PathVariable("id") int id) {
        return rsd.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<RoomStatus> getAllRooms() {
        return rsd.findAll();
    }

    @PostMapping
    public String insert(@RequestBody RoomStatus r){
        rsd.save(r);
        return "Room has been added";
    }

    @PutMapping("/updated")
    public RoomStatus update(@RequestBody RoomStatus r) {
        return rsd.save(r);
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody RoomStatus r) {
        rsd.delete(r);
        return "Room has been deleted";
    }
    
}
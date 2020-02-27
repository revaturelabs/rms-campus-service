package com.rms.controller;

import com.rms.dao.AmenityDao;
import com.rms.model.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmenityController {

    @Autowired
    AmenityDao amd;

    @GetMapping("/{id}")
    public Amenity findById(@PathVariable("id") int id) {
        return amd.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Amenity> getAllRooms() {
        return amd.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Amenity a){
        amd.save(a);
        return "Room has been added";
    }

    @PutMapping("/updated")
    public Amenity update(@RequestBody Amenity a) {
        return amd.save(a);
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Amenity a) {
        amd.delete(a);
        return "Room has been deleted";
    }
}
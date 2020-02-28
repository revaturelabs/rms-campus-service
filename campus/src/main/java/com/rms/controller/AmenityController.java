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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/amenity")
public class AmenityController {

    @Autowired
    AmenityService ams;

    @GetMapping("/{id}")
    public Amenity findById(@PathVariable("id") int id) {
        return ams.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Amenity> getAllAmenities() {
        return ams.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Amenity a){
        ams.save(a);
        return "An amenity has been added";
    }

    @PutMapping("/updated")
    public Amenity update(@RequestBody Amenity a) {
        return ams.save(a);
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Amenity a) {
        ams.delete(a);
        return "An Amenity has been deleted";
    }
}
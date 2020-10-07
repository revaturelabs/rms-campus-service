package com.rms.controller;

import com.rms.dao.BuildingDao;
import com.rms.model.Building;

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
@RequestMapping(value = "/building")
public class BuildingController {

    @Autowired
    BuildingDao bs;

    @GetMapping("/{id}")
    public Building findById(@PathVariable("id") int id) {
        return bs.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Building> getAllBuildings() {
        return bs.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Building b){
        bs.save(b);
        return "Building has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Building b){
        bs.save(b);
        return "Building has been updated";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Building b) {
        bs.delete(b);
        return "Building has been deleted";
    }
}
package com.rms.controller;

import java.util.List;
import java.util.Optional;

import com.rms.model.Building;
import com.rms.service.BuildingService;

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
    BuildingService bs;

    @GetMapping("/{id}")
    public Optional<Building> findById(@PathVariable("id") int id) {
        return bs.read(id);
    }
    
    @PostMapping("/all")
    public List<Building> getAllBuildings() {
        return (List<Building>) bs.readAll();
    }

    @PostMapping
    public String insert(@RequestBody Building b){
        bs.saveOrUpdate(b);
        return "Building has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Building b){
        bs.saveOrUpdate(b);
        return "Building has been updated";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Building b) {
        bs.delete(b);
        return "Building has been deleted";
    }
}
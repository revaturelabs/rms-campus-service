package com.rms.controller;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;

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
@RequestMapping(value = "/campus")
public class CampusController {

    @Autowired
    CampusDao cs;

    @GetMapping("/{id}")
    public Campus findById(@PathVariable("id") int id) {
        return cs.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Campus> getAllCampuses() {
        return cs.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Campus c){
        cs.save(c);
        return "Campus has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Campus c){
        cs.save(c);
        return "Campus has been updated";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Campus c) {
        cs.delete(c);
        return "Campus has been deleted";
    }
}
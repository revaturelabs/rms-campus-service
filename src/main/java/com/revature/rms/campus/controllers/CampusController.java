package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/campus")
public class CampusController {

    @Autowired
    private CampusService campusService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Campus> getAllBuildings() { return campusService.findAll(); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus saveBuilding(@RequestBody Campus campus) {return campusService.save(campus); }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getBuildingById(@PathVariable String id) { return campusService.findById(id).get(); }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus update(@RequestBody Campus campus) { return campusService.update(campus); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBuildingById(@PathVariable String id) { campusService.delete(id);}
}

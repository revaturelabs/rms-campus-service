package com.revature.rms.campus.controllers;


import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/building")
public class BuildingController {

    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Building> getAllBuildings() { return buildingService.findAll(); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Building saveBuilding(@RequestBody Building building) {return buildingService.save(building); }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Building getBuildingById(@PathVariable String id) { return buildingService.findById(id).get(); }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Building update(@RequestBody Building building) { return buildingService.update(building); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBuildingById(@PathVariable String id) { buildingService.delete(id);}
}

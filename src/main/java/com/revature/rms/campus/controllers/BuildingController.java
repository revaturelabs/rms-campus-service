package com.revature.rms.campus.controllers;


import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ErrorResponse;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/building")
public class BuildingController {

    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Building> getAllBuildings() {
        return buildingService.findAll();
    }

    @GetMapping(value = "/trainer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Building getBuildingByTrainingLeadId(@PathVariable int id) { return buildingService.findByTrainingLeadId(Integer.parseInt(id)); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Building saveBuilding(@RequestBody Building building) {
        if (building == null) {
            throw new ResourceNotFoundException();
        }
        return buildingService.save(building);


    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Building getBuildingById(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Optional<Building> _building = buildingService.findById(id);
        if (!_building.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return buildingService.findById(id).get();
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Building updateBuilding(@RequestBody Building building) {
        return buildingService.update(building);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBuildingById(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        buildingService.delete(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidInputException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(400);
        return err;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(401);
        return err;
    }
}

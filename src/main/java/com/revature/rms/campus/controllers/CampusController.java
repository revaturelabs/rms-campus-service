package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.CampusService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/campus")
public class CampusController {

    private CampusService campusService;

    @Autowired
    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Campus> getAllCampus() { return campusService.findAll(); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus saveCampus(@RequestBody Campus campus) {
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campusService.save(campus);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getCampusById(@PathVariable String id) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        Optional<Campus> _campus = campusService.findById(id);
        if (!_campus.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return campusService.findById(id).get();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus updateCampus(@RequestBody Campus campus) { return campusService.update(campus); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCampusById(@PathVariable String id) {
        if(id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        campusService.delete(id);}
}

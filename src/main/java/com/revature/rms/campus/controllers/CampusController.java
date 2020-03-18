package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.*;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "/training/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getCampusByTrainingManagerId(@PathVariable String id) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        Campus campus = campusService.findByTrainingManagerId(Integer.parseInt(id));
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    @GetMapping(value = "/staging/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getCampusByStagingManagerId(@PathVariable String id) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        Campus campus = campusService.findByStagingManagerId(Integer.parseInt(id));
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus updateCampus(@RequestBody Campus campus) { return campusService.update(campus); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCampusById(@PathVariable String id) {
        if(id.isEmpty() || Integer.parseInt(id) <= 0) {
            throw new InvalidInputException();
        }
        campusService.delete(id);
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

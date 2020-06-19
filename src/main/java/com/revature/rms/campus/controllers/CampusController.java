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

/**
 * Rest controller for the CampusService. All of the methods below either produce or produce and consume JSON values
 * The methods provide validations through the result of TDD in CampusServiceTests and CampusControllerTests.
 * Methods include:
 * - getAllCampus, this method performs a get with the url in the RequestMapping annotation and returns the result
 * of campusService.findAll() as a list of JSON campus objects.
 * - saveCampus, this method performs a post with provided url in the RequestMapping annotation. Expected the provided
 * information to be a JSON and returns the JSON of campusService.save()
 * - getCampusById, this method performs a get with the url in the RequestMapping annotation and including the provided
 * param. Returns the result of campusService.findById() as a JSON.
 * - updateCampus this method performs a put with the provided url and returns the result of campusService.update().
 * - deleteCampusById, this method performs a get with the url in the RequestMapping annotation and including the provided
 *  * param. Returns the result of campusService.delete() as a JSON.
 */
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
    public Campus getCampusById(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Optional<Campus> _campus = campusService.findById(id);
        if (!_campus.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return campusService.findById(id).get();
    }

    @GetMapping(value = "/training/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Campus> getCampusByTrainingManagerId(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        List<Campus> campus = campusService.findByTrainingManagerId(id);
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    @GetMapping(value = "/staging/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Campus> getCampusByStagingManagerId(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        List<Campus> campus = campusService.findByStagingManagerId(id);
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus updateCampus(@RequestBody Campus campus) { return campusService.update(campus); }

    @DeleteMapping(value = "/{id}")
    public boolean deleteCampusById(@PathVariable int id) {
        if(id <= 0) {
            throw new InvalidInputException();
        }
        campusService.delete(id);
        return true;
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

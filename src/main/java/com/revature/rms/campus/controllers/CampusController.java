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

    /**
     * getAllCampus method: Returns a list of all the campus objects in the database.
     * @return a list of all the campuses
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Campus> getAllCampus() { return campusService.findAll(); }

    /**
     * saveCampus method: Takes in a campus object as the input.
     * @param campus newly persisted campus object
     * @return the newly added campus object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus saveCampus(@RequestBody Campus campus) {
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campusService.save(campus);
    }

    /**
     * getCampusById method: Returns a campus object when the id int matches a record in the database.
     * @param id campusId int value
     * @return a campus with matching id
     */
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

    /**
     * getCampusByTrainingManagerId method: Returns a campus object
     * that matches a trainingLeadId int id.
     * @param id trainingLeadId int value
     * @return a campus with matching trainerLeadId
     */
    @GetMapping(value = "/training/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getCampusByTrainingManagerId(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Campus campus = campusService.findByTrainingManagerId(id);
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    /**
     * getCampusByStagingManagerId method: Returns a campus object
     * that matches a stagingManagerId int id.
     * @param id stagingManagerId int value
     * @return a campus with matching stagingManagerId
     */
    @GetMapping(value = "/staging/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus getCampusByStagingManagerId(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Campus campus = campusService.findByStagingManagerId(id);
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
        return campus;
    }

    /**
     * updateCampus method: The campus object is inputted and changes are saved.
     * @param campus newly updated campus object
     * @return updated/modified campus object
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Campus updateCampus(@RequestBody Campus campus) { return campusService.update(campus); }

    /**
     * deleteCampusById method: The campus object is deleted based on its campusId int
     * @param id campusId int value
     */
    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCampusById(@PathVariable int id) {
        if(id <= 0) {
            throw new InvalidInputException();
        }
        campusService.delete(id);
    }

    /**
     * handleInvalidRequestException method: Exception handler method that provides the correct
     * error response based on a InvalidInputException
     * @param e InvalidInputException where input from user is invalid
     * @return ErrorResponse that provides status, message, and timestamp of the exception
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidInputException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(400);
        return err;
    }

    /**
     * handleResourceNotFoundException method: Exception handler method that provides the correct
     * error response based on a ResourceNotFoundException
     * @param e ResourceNotFoundException where a resource is not found in the database
     * @return ErrorResponse that provides status, message, and timestamp of the exception
     */
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

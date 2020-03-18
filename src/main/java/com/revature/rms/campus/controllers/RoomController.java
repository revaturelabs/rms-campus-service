package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Building;
import com.revature.rms.campus.entities.ErrorResponse;
import com.revature.rms.campus.entities.Room;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.services.BuildingService;
import com.revature.rms.campus.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/room")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getAllRooms() { return roomService.findAll(); }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room saveRoom(@RequestBody Room room) {
        if(room == null){
            throw new ResourceNotFoundException();
        }
        return roomService.save(room); }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoomById(@PathVariable String id) {
        if(id.isEmpty() || Integer.parseInt(id) <= 0){
            throw new InvalidInputException();
        }
        Optional<Room> _room = roomService.findById(id);
        if(!_room.isPresent()){
            throw new ResourceNotFoundException();
        }
    return roomService.findById(id).get();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room updateRoom(@RequestBody Room room) { return roomService.update(room); }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRoomById(@PathVariable String id) {
        if(id.isEmpty() || Integer.parseInt(id) <= 0){
            throw new InvalidInputException();
        }
        roomService.delete(id);}

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

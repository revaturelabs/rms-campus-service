package com.revature.rms.campus.controllers;

import com.revature.rms.campus.documents.Room;
import com.revature.rms.campus.services.RoomService;
import com.revature.rms.core.controllers.ResourceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController extends ResourceController<Room> {

    public RoomController(RoomService service) {
        super(service);
    }

}

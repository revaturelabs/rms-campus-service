package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.services.CampusService;
import com.revature.rms.core.controllers.ResourceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campus")
public class CampusController extends ResourceController<Campus> {

    public CampusController(CampusService service) {
        super(service);
    }

}

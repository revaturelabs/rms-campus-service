package com.revature.rms.campus.controllers;

import com.revature.rms.campus.documents.Building;
import com.revature.rms.campus.services.BuildingService;
import com.revature.rms.core.controllers.ResourceController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController extends ResourceController<Building> {

    public BuildingController(BuildingService service) {
        super(service);
    }

}

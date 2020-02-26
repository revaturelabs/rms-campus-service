package com.rms.controller;

import com.rms.dao.BuildingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {
    
    @Autowired
    BuildingDao bd;
}
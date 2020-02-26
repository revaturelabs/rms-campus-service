package com.rms.controller;

import com.rms.dao.AmenityDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmenityController {
    
    @Autowired
    AmenityDao amd;

}
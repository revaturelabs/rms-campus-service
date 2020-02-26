package com.rms.controller;

import com.rms.dao.AmenityTypeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmenityTypeController {
    
    @Autowired
    AmenityTypeDao atd;


}
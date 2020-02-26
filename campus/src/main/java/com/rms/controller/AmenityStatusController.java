package com.rms.controller;

import com.rms.dao.AmenityStatusDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmenityStatusController {
    
    @Autowired
    AmenityStatusDao asd;


}
package com.rms.controller;

import com.rms.dao.RoomStatusDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomStatusController {

    @Autowired
    RoomStatusDao rsd;
    
}
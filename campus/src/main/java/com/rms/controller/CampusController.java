package com.rms.controller;

import com.rms.dao.CampusDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampusController {

    @Autowired
    CampusDao cd;
}
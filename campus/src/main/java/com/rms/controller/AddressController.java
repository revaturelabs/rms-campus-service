package com.rms.controller;

import com.rms.dao.AddressDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    
    @Autowired
    AddressDao ad;

    
}
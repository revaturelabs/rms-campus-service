package com.rms.controller;

import java.util.Optional;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AddressController {
    
    @Autowired
    private AddressDao ad;
    

    @GetMapping(value="/{id}")
    public Optional<Address> getById(@PathVariable("id") int id) {
        return ad.findById(id);
    }
    
}
package com.rms.controller;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressDao as;

    @GetMapping("/{id}")
    public Address findById(@PathVariable("id") int id) {
        return as.findById(id).get();
    }
    
    @PostMapping("/all")
    public Iterable<Address> getAllAddresses() {
        return as.findAll();
    }

    @PostMapping
    public String insert(@RequestBody Address a){
        as.save(a);
        return "Address has been added";
    }

    @PutMapping("/updated")
    public String update(@RequestBody Address a){
        as.save(a);
        return "Address has been updated";
    }

    @DeleteMapping("/deleted")
    public String delete(@RequestBody Address a) {
        as.delete(a);
        return "Address has been deleted";
    }
    
}
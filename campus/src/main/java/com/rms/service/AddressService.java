package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.AddressDao;
import com.rms.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressDao ad;

    public void saveOrUpdate(Address add) {
        ad.save(add);
    }

    public void delete(Address add) {
        ad.delete(add);
    }

    public Optional<Address> read(int id) {
        return ad.findById(id);
    }

    public List<Address> readAll() {
        return (List<Address>) ad.findAll();
    }
}
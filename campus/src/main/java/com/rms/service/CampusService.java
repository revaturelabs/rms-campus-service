package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.model.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    @Autowired
    CampusService cs;

    public void save(Campus camp) {
        cs.save(camp);
    }

    public void delete(Campus camp){
        cs.delete(camp);
    }

    public void update(Campus camp){
        cs.save(camp);
    }

    public Optional<Campus> findById(int id){
        return cs.findById(id);
    }

    public List<Campus> findAll() {
        return (List<Campus>) cs.findAll();
    }
}


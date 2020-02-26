package com.rms.service;

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
}


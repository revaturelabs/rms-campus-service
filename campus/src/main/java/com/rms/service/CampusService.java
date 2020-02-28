package com.rms.service;

import java.util.List;
import java.util.Optional;

import com.rms.dao.CampusDao;
import com.rms.model.Campus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    @Autowired
    CampusDao cd;

    public void saveOrUpdate(Campus cam) {
        cd.save(cam);
    }

    public void delete(Campus cam) {
        cd.delete(cam);
    }

    public Optional<Campus> read(int id) {
        return cd.findById(id);
    }

    public List<Campus> readAll() {
        return (List<Campus>) cd.findAll();
    }
}


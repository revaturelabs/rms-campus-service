package com.rms.controller;

import com.rms.dao.ResourceMetadataDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceMetadataController {
    
    @Autowired
    ResourceMetadataDao rmd;
    
}
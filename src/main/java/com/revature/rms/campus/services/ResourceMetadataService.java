package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.repositories.ResourceMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceMetadataService {

    @Autowired
    private ResourceMetadataRepository metadataRepository;

    @Transactional
    public ResourceMetadata deactivateResource(ResourceMetadata resourceMetadata) {
        ResourceMetadata resource = metadataRepository.findById(resourceMetadata.getId()).get();
        resource.setActive(false);
        return resource;

    }

}

package com.revature.rms.campus.services;

import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.repositories.ResourceMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The methods in this service call to methods from the metadataRepository in order to give the basic CRUD features to
 * the application. The methods in this service are custom as a result of TDD. For more information about the testing
 * see ResourceMetadataServiceTests.
 */
@Service
public class ResourceMetadataService {

    @Autowired
    private ResourceMetadataRepository metadataRepository;

    /**
     * deactivateResource Method: finds the specific ResourceMetadata in the database, sets currentlyActive to false and persist the object to the database.
     * @param resourceMetadata ResourceMetadata Object.
     * @return Return the modified ResourceMetadata Object.
     */
    @Transactional
    public ResourceMetadata deactivateResource(ResourceMetadata resourceMetadata) {
        ResourceMetadata resource = metadataRepository.findById(resourceMetadata.getId()).get();
        resource.setCurrentlyActive(false);
        metadataRepository.save(resource);
        return resource;

    }

}

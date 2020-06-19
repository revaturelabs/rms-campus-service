package com.revature.rms.campus.services;


import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
import com.revature.rms.campus.repositories.AddressRepository;
import com.revature.rms.campus.repositories.CampusRepository;
import com.revature.rms.campus.repositories.ResourceMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The methods in this service call to methods from the campusRepository, addressRepository, metadataService and metadataRepository in order to give the basic CRUD features to
 * the application. The methods in this service are custom as a result of TDD. For more information about the testing
 * see CampusServiceTests.
 */
@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private ResourceMetadataRepository metadataRepository;

    @Autowired
    private ResourceMetadataService metadataService;

    @Autowired
    private AddressRepository addressRepository;

    /**
     *  save Method: this method returns the result of campusRepository.save when a non-null campus object is passed in.
     *  * Otherwise this method will throw a ResourceNotFoundException as the desired campus to save is missing. Campus field
     *  * level validation is handled in entities.Campus
     * @param campus Takes in a Campus object to be persisted to the database.
     * @return The persisted Campus object with its specific serialized id.
     */
    @Transactional
    public Campus save(Campus campus) {
        if (campus == null) {
            throw new ResourceNotFoundException();
        }

        Address address = addressRepository.save(campus.getShippingAddress());
        ResourceMetadata data = metadataRepository.save(campus.getResourceMetadata());
        campus.setShippingAddress(address);
        campus.setResourceMetadata(data);
        Campus persisted = campusRepository.save(campus);
        return persisted;
    }

    /**
     * findAll Method: this method returns the result of campusRepository.findAll. The method will return a list of Campus
     *  * objects if there are any existing. Otherwise, it will return an empty list.
     * @return An arraylist of Campus Objects.
     */
    @Transactional(readOnly = true)
    public List<Campus> findAll() {
        Iterable<Campus> r = campusRepository.findAll();
        List<Campus> list = getListFromIterator(r);
        return list;
    }

    /**
     *  findById Method: this method returns the result of campusMongoRepository.findById. If the provided input is invalid, an
     *  * empty string or and int less than or equal to 0 the method will thrown an InvalidInputException. Alternatively, if
     *  * the id is valid but there is no campus object associated with the id, the method will throw a
     *  * ResourceNotFoundException.
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<Campus> findById(int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Optional<Campus> _campus = campusRepository.findById(id);
        if (!_campus.isPresent()) {
            throw new  ResourceNotFoundException();
        }
        return _campus;
    }

    /**
     * findByTrainingManagerId Method: searches for a list of Campuses by the training Manager ID, if the ID is less than 1 it will throw and InvalidInputException.
     *  * If the List of campuses is null it will throw a ResourceNotFoundException.
     * @param id Passes as a parameter an Integer of name id.
     * @return Returns a list of Campus Objects.
     */
    @Transactional(readOnly = true)
    public List<Campus> findByTrainingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
         List<Campus> campus = campusRepository.findByTrainingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

    /**
     * findByStagingManagerId Method: searches for a list of Campuses by the staging Manager ID, if the ID is less than 1 it will throw and InvalidInputException.
     *  * If the List of campuses is null it will throw a ResourceNotFoundException.
     * @param id Passes as a parameter an Integer of name id.
     * @return Returns a list of Campus Objects.
     */
    @Transactional(readOnly = true)
    public List<Campus> findByStagingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
        List<Campus> campus = campusRepository.findByStagingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

    /**
     * findByName Method: this method returns the result of campusRepository.findByName. This is a custom method made for
     *  * proof of concept and thoughts of additional functionality. The method functions similar to findById but instead will
     *  * return the object using either the name or the abbreviatedName associated with the campus object. Because this method
     *  * has not been used there is no validation other than testing functionality. If deciding to implement please develop
     *  * with TDD in the CampusServiceTests.
     * @param name Takes in a string of the campus name or abbreviation name.
     * @return Returns a campus Object.
     */
    @Transactional(readOnly = true)
    public Campus findByName(String name) {
        return campusRepository.findByName(name);
    }

    /**
     * update Method: This method updates a currently persisted object by using the save method to overwrite any changes method to the passed in Campus Object.
     * @param campus Campus object
     * @return Returns the modified Campus Object.
     */
    @Transactional
    public Campus update(Campus campus) {
        return campusRepository.save(campus);
    }

    /**
     * delete Method: This method soft deletes the campus object by changing the boolean value of the field currentlyActive to false,
     * that belongs to the ResourceMetadata of the specified Campus Object.
     * @param id int value that is used to find the Campus Object.
     * @return Returns the boolean value of true.
     */
    @Transactional
    public boolean delete(int id) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
        Campus campus = campusRepository.findById(id).get();
        ResourceMetadata metadata = metadataService.deactivateResource(campus.getResourceMetadata());
        campus.setResourceMetadata(metadata);
        campusRepository.save(campus);
        return true;
    }

    /**
     * getListFromIterator Method: Is a custom method that iterates and adds each object to a list of the specified Generic.
     * @param iterable an Iterable that wants to be converted into an ArrayList
     * @param <T> Generic of any ObjectType
     * @return Returns a List of type T
     */
    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}

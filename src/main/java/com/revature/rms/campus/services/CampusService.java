package com.revature.rms.campus.services;


import com.revature.rms.campus.entities.Address;
import com.revature.rms.campus.entities.Campus;
import com.revature.rms.campus.entities.ResourceMetadata;
import com.revature.rms.campus.entities.RoomStatus;
import com.revature.rms.campus.exceptions.InvalidInputException;
import com.revature.rms.campus.exceptions.ResourceNotFoundException;
//import com.revature.rms.campus.repositories.CampusMongoRepository;
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
 * The methods in this service call to methods from the campusMongoRepository in order to give the basic CRUD features to
 * the application. The methods in this service are custom as a result of TDD. For more information about the testing
 * see CampusServiceTests.
 * The methods in this service are:
 * - save(), this method returns the result of campusMongoRepository.save when a non-null campus object is passed in.
 * Otherwise this method will throw a ResourceNotFoundException as the desired campus to save is missing. Campus field
 * level validation is handled in entities.Campus
 * - findAll(), this method returns the result of campusMongoRepository.findAll. The method will return a list of Campus
 * objects if there are any existing. Otherwise, it will return an empty list.
 * - findById, this method returns the result of campusMongoRepository.findById. If the provided input is invalid, an
 * empty string or and int less than or equal to 0 the method will thrown an InvalidInputException. Alternatively, if
 * the id is valid but there is no campus object associated with the id, the method will throw a
 * ResourceNotFoundException.
 * - findByName, this method returns the result of campusMongoRepository.findByName. This is a custom method made for
 * proof of concept and thoughts of additional functionality. The method functions similar to findById but instead will
 * return the object using either the name or the abbreviatedName associated with the campus object. Because this method
 * has not been used there is no validation other than testing functionality. If deciding to implement please develop
 * with TDD in the CampusServiceTests.
 * - update, this method returns the result of campusMongoRepository.save. This will update the edited fields for the
 * persisted campus object. Since the object is already persisted when using this method, there is no reason to check
 * if it's null. Additionally field checks are still handled in entities.Campus.
 * - delete, this method uses campusMongoRepository.deleteById. This will delete the persisted object from the database
 * if the user has provided a valid id. If the provided input is invalid, an empty string or and int less than or equal
 * to 0 the method will thrown an InvalidInputException. No exception a valid id but no associated object. Technically,
 * this object does not exist and therefore is not an issue.
 */
@Service
public class CampusService {

//    private CampusMongoRepository campusMongoRepository;
    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private ResourceMetadataRepository metadataRepository;

    @Autowired
    private AddressRepository addressRepository;

//    public CampusService(CampusMongoRepository repo) {
//        this.campusMongoRepository = repo;
//    }

    @Transactional
    public Campus save(Campus campus) {
        if (campus == null) {
            throw new ResourceNotFoundException();
        }
//        return campusMongoRepository.save(campus);

        Address address = addressRepository.save(campus.getShippingAddress());
        ResourceMetadata data = metadataRepository.save(campus.getResourceMetadata());
        campus.setShippingAddress(address);
        campus.setResourceMetadata(data);
        Campus persisted = campusRepository.save(campus);
        return persisted;
    }


//    public List<Campus> findAll() {
//        return campusMongoRepository.findAll();
//    }
    @Transactional(readOnly = true)
    public List<Campus> findAll() {
        Iterable<Campus> r = campusRepository.findAll();
        List<Campus> list = getListFromIterator(r);
        return list;
//        return campusRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Campus> findById(int id) {
//        if (id.isEmpty() || (Integer.parseInt(id) <= 0)) {
        if (id <= 0) {
            throw new InvalidInputException();
        }
//        Optional<Campus> _campus = campusMongoRepository.findById(id);
        Optional<Campus> _campus = campusRepository.findById(id);
        if (!_campus.isPresent()) {
            throw new  ResourceNotFoundException();
        }
        return _campus;
    }

    @Transactional(readOnly = true)
    public Campus findByTrainingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
//        Campus campus = campusMongoRepository.findByTrainingManagerId(id);
        Campus campus = campusRepository.findByTrainingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

    @Transactional(readOnly = true)
    public Campus findByStagingManagerId(Integer id) {
        if (id < 1) {
            throw new InvalidInputException();
        }
//        Campus campus = campusMongoRepository.findByStagingManagerId(id);
        Campus campus = campusRepository.findByStagingManagerId(id);
        if (campus == null) throw new ResourceNotFoundException();
        else return campus;
    }

//    public Campus findByName(String name) {
//        return campusMongoRepository.findByName(name);
//    }
    @Transactional(readOnly = true)
    public Campus findByName(String name) {
        return campusRepository.findByName(name);
    }

//    public Campus update(Campus campus) {
//        return campusMongoRepository.save(campus);
//    }
    @Transactional
    public Campus update(Campus campus) {
        return campusRepository.save(campus);
    }

    @Transactional
    public void delete(int id) {
//        if (id.isEmpty() || Integer.parseInt(id) <= 0) { 
        if (id <= 0) {
            throw new InvalidInputException();
        }
//        campusMongoRepository.deleteById(id);
        campusRepository.deleteById(id);
    }

    //added to convert to h2
    public static <T> List<T> getListFromIterator(Iterable<T> iterable)
    {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}

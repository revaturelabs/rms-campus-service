package com.revature.rms.campus.repositories;


import com.revature.rms.campus.entities.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//public interface UserMongoRepository extends MongoRepository<User, String> {
//    User findByFirstName(String firstName);
//}

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByFirstName(String firstName);
}
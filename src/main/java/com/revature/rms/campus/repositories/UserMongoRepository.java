package com.revature.rms.campus.repositories;


import com.revature.rms.campus.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByFirstName(String firstName);
}

package com.revature.rms.campus.repos;

import com.revature.rms.campus.entities.Campus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends ReactiveMongoRepository<Campus, String> {
}

package com.revature.rms.campus.repos;

import com.revature.rms.campus.entities.Campus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CampusRepository extends ReactiveMongoRepository<Campus, String> {
}

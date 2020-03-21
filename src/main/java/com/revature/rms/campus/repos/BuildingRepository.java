package com.revature.rms.campus.repos;

import com.revature.rms.campus.entities.Building;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BuildingRepository extends ReactiveMongoRepository<Building, String> {
}

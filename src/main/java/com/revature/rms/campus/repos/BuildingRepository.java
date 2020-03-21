package com.revature.rms.campus.repos;

import com.revature.rms.campus.entities.Building;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends ReactiveMongoRepository<Building, String> {
}

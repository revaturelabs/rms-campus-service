package com.revature.rms.campus.services;

import com.revature.rms.campus.documents.Campus;
import com.revature.rms.campus.repos.CampusRepository;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class CampusService extends ResourceService<Campus> {

    private BuildingService buildingService;

    public CampusService(CampusRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

    @Autowired
    public void setBuildingService(BuildingService service) {
        this.buildingService = service;
    }

    @Override
    public Flux<Void> deleteAllById(Iterable<String> ids) {

        return this.repo.findAllById(ids)
                        .flatMap(campus -> {
                            Iterable<String> bldgIds = campus.getBuildings().stream().map(Resource::getId).collect(Collectors.toList());
                            return buildingService.deleteAllById(bldgIds).then(Mono.just(campus));
                        })
                        .flatMap(campus -> {
                            Query query = new Query(Criteria.where("id").is(campus.getId()));
                            campus.getMetadata().setActive(false);
                            return mongoTemplate.findAndReplace(query, campus).then();
                        });
    }

}

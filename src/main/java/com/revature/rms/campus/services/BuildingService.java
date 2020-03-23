package com.revature.rms.campus.services;

import com.revature.rms.campus.documents.Building;
import com.revature.rms.campus.repos.BuildingRepository;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class BuildingService extends ResourceService<Building> {

    private RoomService roomService;

    public BuildingService(BuildingRepository repo, ReactiveMongoTemplate template) {
        super(repo, template);
    }

    @Autowired
    public void setRoomRepo(RoomService service) {
        this.roomService = service;
    }

    @Override
    public Flux<Void> deleteAllById(Iterable<String> ids) {

        return this.repo.findAllById(ids)
                .flatMap(bldg -> {
                    Iterable<String> roomIds = bldg.getRooms().stream().map(Resource::getId).collect(Collectors.toList());
                    return roomService.deleteAllById(roomIds).then(Mono.just(bldg));
                })
                .flatMap(bldg -> {
                    Query query = new Query(Criteria.where("id").is(bldg.getId()));
                    bldg.getMetadata().setActive(false);
                    return mongoTemplate.findAndReplace(query, bldg).then();
                });
    }

}

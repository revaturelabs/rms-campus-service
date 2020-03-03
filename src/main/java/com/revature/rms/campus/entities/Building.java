package com.revature.rms.campus.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    private Integer id;
    private String name;
    private String abbrName;
    private Address physicalAddress;
    private Integer trainingLead;
    private ArrayList<Amenity> amenities;
    private ArrayList<Room> rooms;
    private ResourceMetadata resourceMetaData;

    public Building(String name, String abbrName, Address physicalAddress, Integer trainingLead, ArrayList<Amenity> amenities, ArrayList<Room> rooms, ResourceMetadata resourceMetaData) {
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetaData = resourceMetaData;
    }
}

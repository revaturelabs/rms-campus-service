package com.revature.rms.campus.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String abbrName;

    @NotNull
    private Address physicalAddress;

    @NotNull
    private Integer trainingLead;

    @NotNull
    @NotEmpty
    private ArrayList<Amenity> amenities;

    @NotNull
    @NotEmpty
    private ArrayList<Room> rooms;

    @NotNull
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

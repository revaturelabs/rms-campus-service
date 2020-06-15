package com.revature.rms.campus.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


//@Document

//commentted out bc mangodb
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false,unique=true) //covert h2
    private String name;

    @Column(nullable=false) //covert h2
    private String abbrName;

    @OneToOne
    @JoinColumn(nullable=false) //covert h2
    private Address physicalAddress;

    @Column(nullable=false) //covert h2
    private Integer trainingLead;

//    @NotNull
//    @NotEmpty
    @OneToMany(mappedBy = "building")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private List<Amenity> amenities;

    @OneToMany(mappedBy = "building")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private List<Room> rooms;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private ResourceMetadata resourceMetaData;

    @ManyToOne
    private Campus campus;


    public Building() {
    }

    public Building(int id, String name, String abbrName, Address physicalAddress, Integer trainingLead, List<Amenity> amenities, List<Room> rooms, ResourceMetadata resourceMetaData) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetaData = resourceMetaData;
    }

    public Building(String name, String abbrName, Address physicalAddress, Integer trainingLead, List<Amenity> amenities, List<Room> rooms, ResourceMetadata resourceMetaData) {
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetaData = resourceMetaData;
    }
}

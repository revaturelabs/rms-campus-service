package com.revature.rms.campus.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;


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
    private int trainingLead;

//    @NotNull
//    @NotEmpty
    @OneToMany(mappedBy = "building")
    private List<Amenity> amenities;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ResourceMetadata resourceMetadata;

    @ManyToOne
    @JsonIgnore
    private Campus campus;


    public Building() {
    }

    public Building(int id, String name, String abbrName, Address physicalAddress, int trainingLead, List<Amenity> amenities, List<Room> rooms, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetadata = resourceMetadata;
    }

    public Building(String name, String abbrName, Address physicalAddress, int trainingLead, List<Amenity> amenities, List<Room> rooms, ResourceMetadata resourceMetadata) {
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
        this.resourceMetadata = resourceMetadata;
    }

    public Building(int id, String name, String abbrName, Address physicalAddress, int trainingLead, List<Amenity> amenities, ResourceMetadata resourceMetadata, Campus campus) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.resourceMetadata = resourceMetadata;
        this.campus = campus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }
}

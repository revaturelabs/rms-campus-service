package com.revature.rms.campus.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


//@Document

//commentted out bc mangodb
//@AllArgsConstructor
//@NoArgsConstructor
/**
 * POJO for the campus object. The annotations:
 * @Data handles the getter and setter methods for each field
 * @Document handles the mapping to the database
 * @ToString handles the HashCode and ToString
 * @AllArgsConstructor handles the all arguments constructor
 * @NoArgsConstructor handles the no arguments constructor
 * @Id marks the selected field as a primary key
 * @NotNull ensures the field will cannot be null, all values except for abbrName are not null
 * @NotEmpty ensures the field will not be empty, buildings and corporateEmployees are ArrayLists so we dont' want these
 * fields to be empty either
 *
 * Lastly, we have a constructor containing every field except for the id.
 */
@Data
@ToString
@Entity
public class Campus {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

//    @NotNull
    @Column(nullable=false,unique=true) //covert h2
    private String name;

    @Column(nullable=false) //covert h2
    private String abbrName;

//    @NotNull
    @OneToOne
    @JoinColumn(nullable=false)
    private Address shippingAddress;

//    @NotNull
    @Column(nullable=false)
    private int trainingManagerId;

//    @NotNull
    @Column(nullable=false)
    private int stagingManagerId;

//    @NotNull
    @Column(nullable=false)
    private int hrLead;

//    @NotNull
//    @NotEmpty
    @OneToMany(mappedBy = "campus")
    private List<Building> buildings;

//    @NotNull
//    @NotEmpty

//    @Column(nullable=false) //covert h2
    @ElementCollection
    private List<Integer> corporateEmployees;

//    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ResourceMetadata resourceMetadata;

    @Embedded
    private ResourceMetadataEmbeddable resourceMetadataEmbeddable;

    public Campus() {
    }

    public Campus(int id, String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, ArrayList<Building> buildings, ArrayList<Integer> corporateEmployees, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.shippingAddress = shippingAddress;
        this.trainingManagerId = trainingManagerId;
        this.stagingManagerId = stagingManagerId;
        this.hrLead = hrLead;
        this.buildings = buildings;
        this.corporateEmployees = corporateEmployees;
        this.resourceMetadata = resourceMetadata;
    }

    public Campus(String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, ArrayList<Building> buildings, ArrayList<Integer> corporateEmployees, ResourceMetadata resourceMetadata) {
        this.name = name;
        this.abbrName = abbrName;
        this.shippingAddress = shippingAddress;
        this.trainingManagerId = trainingManagerId;
        this.stagingManagerId = stagingManagerId;
        this.hrLead = hrLead;
        this.buildings = buildings;
        this.corporateEmployees = corporateEmployees;
        this.resourceMetadata = resourceMetadata;
    }

    public Campus(int id, String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, List<Integer> corporateEmployees, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.shippingAddress = shippingAddress;
        this.trainingManagerId = trainingManagerId;
        this.stagingManagerId = stagingManagerId;
        this.hrLead = hrLead;
        this.corporateEmployees = corporateEmployees;
        this.resourceMetadata = resourceMetadata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public ResourceMetadata getResourceMetadata() {
        return resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}

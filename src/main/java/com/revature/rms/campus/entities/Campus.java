package com.revature.rms.campus.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
public class Campus {

    @Id
    private String id;

    @NotNull
    private String name;
    private String abbrName;

    @NotNull
    private Address shippingAddress;

    @NotNull
    private int trainingManagerId;

    @NotNull
    private int stagingManagerId;

    @NotNull
    private int hrLead;

    @NotNull
    @NotEmpty
    private ArrayList<Building> buildings;

    @NotNull
    @NotEmpty
    private ArrayList<Integer> corporateEmployees;

    @NotNull
    private ResourceMetadata resourceMetadata;

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
}

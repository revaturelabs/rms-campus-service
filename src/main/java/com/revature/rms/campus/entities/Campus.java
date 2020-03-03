package com.revature.rms.campus.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Campus {

    @Id
    private int id;
    private String name;
    private String abbrName;
    private Address shippingAddress;
    private int trainingManagerId;
    private int stagingManagerId;
    private int hrLead;
    private Building[] buildings;
    private int[] corporateEmployees;
    private ResourceMetadata resourceMetadata;

    public Campus(String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, Building[] buildings, int[] corporateEmployees, ResourceMetadata resourceMetadata) {
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

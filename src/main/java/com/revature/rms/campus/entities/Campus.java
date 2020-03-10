package com.revature.rms.campus.entities;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor

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

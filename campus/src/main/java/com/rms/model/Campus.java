package com.rms.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Campus{

    @Id
    @SequenceGenerator(name = "CampID_seq", sequenceName = "CampID_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CampID_seq")
    private int id;
    private String name;
    private String abbrName;
    @OneToOne
    private Address shippingAddress;
    private int trainingManagerId;
    private int stagingManagerId;
    private int hrLead;
    private Building[] buildings;
    private int[] corporateEmployees;
    @OneToOne
    private ResourceMetadata resourceMetadata;

    public Campus() {
    }

    public Campus(int id, String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, Building[] buildings, int[] corporateEmployees, ResourceMetadata resourceMetadata) {
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrName() {
        return this.abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getTrainingManagerId() {
        return this.trainingManagerId;
    }

    public void setTrainingManagerId(int trainingManagerId) {
        this.trainingManagerId = trainingManagerId;
    }

    public int getStagingManagerId() {
        return this.stagingManagerId;
    }

    public void setStagingManagerId(int stagingManagerId) {
        this.stagingManagerId = stagingManagerId;
    }

    public int getHrLead() {
        return this.hrLead;
    }

    public void setHrLead(int hrLead) {
        this.hrLead = hrLead;
    }

    public Building[] getBuildings() {
        return this.buildings;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public int[] getCorporateEmployees() {
        return this.corporateEmployees;
    }

    public void setCorporateEmployees(int[] corporateEmployees) {
        this.corporateEmployees = corporateEmployees;
    }

    public ResourceMetadata getResourceMetadata() {
        return this.resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public Campus id(int id) {
        this.id = id;
        return this;
    }

    public Campus name(String name) {
        this.name = name;
        return this;
    }

    public Campus abbrName(String abbrName) {
        this.abbrName = abbrName;
        return this;
    }

    public Campus shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public Campus trainingManagerId(int trainingManagerId) {
        this.trainingManagerId = trainingManagerId;
        return this;
    }

    public Campus stagingManagerId(int stagingManagerId) {
        this.stagingManagerId = stagingManagerId;
        return this;
    }

    public Campus hrLead(int hrLead) {
        this.hrLead = hrLead;
        return this;
    }

    public Campus buildings(Building[] buildings) {
        this.buildings = buildings;
        return this;
    }

    public Campus corporateEmployees(int[] corporateEmployees) {
        this.corporateEmployees = corporateEmployees;
        return this;
    }

    public Campus resourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Campus)) {
            return false;
        }
        Campus campus = (Campus) o;
        return id == campus.id && Objects.equals(name, campus.name) && Objects.equals(abbrName, campus.abbrName) && Objects.equals(shippingAddress, campus.shippingAddress) && trainingManagerId == campus.trainingManagerId && stagingManagerId == campus.stagingManagerId && hrLead == campus.hrLead && Objects.equals(buildings, campus.buildings) && Objects.equals(corporateEmployees, campus.corporateEmployees) && Objects.equals(resourceMetadata, campus.resourceMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbrName, shippingAddress, trainingManagerId, stagingManagerId, hrLead, buildings, corporateEmployees, resourceMetadata);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", abbrName='" + getAbbrName() + "'" +
            ", shippingAddress='" + getShippingAddress() + "'" +
            ", trainingManagerId='" + getTrainingManagerId() + "'" +
            ", stagingManagerId='" + getStagingManagerId() + "'" +
            ", hrLead='" + getHrLead() + "'" +
            ", buildings='" + getBuildings() + "'" +
            ", corporateEmployees='" + getCorporateEmployees() + "'" +
            ", resourceMetadata='" + getResourceMetadata() + "'" +
            "}";
    }

   
}
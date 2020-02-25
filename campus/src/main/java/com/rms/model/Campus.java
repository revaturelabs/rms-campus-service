package com.rms.model;

import java.util.Objects;

public class Campus{
    private int id;
    private String name;
    private String abbrName;
    private Address shippingAddress;
    private int trainingManagerId;
    private int stagingManagerId;
    private int hrLead;
    private Building[] buildings;
    private int[] corporateEmployees;

    public Campus() {
    }

    public Campus(int id, String name, String abbrName, Address shippingAddress, int trainingManagerId, int stagingManagerId, int hrLead, Building[] buildings, int[] corporateEmployees) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.shippingAddress = shippingAddress;
        this.trainingManagerId = trainingManagerId;
        this.stagingManagerId = stagingManagerId;
        this.hrLead = hrLead;
        this.buildings = buildings;
        this.corporateEmployees = corporateEmployees;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Campus)) {
            return false;
        }
        Campus campus = (Campus) o;
        return id == campus.id && Objects.equals(name, campus.name) && Objects.equals(abbrName, campus.abbrName) && Objects.equals(shippingAddress, campus.shippingAddress) && trainingManagerId == campus.trainingManagerId && stagingManagerId == campus.stagingManagerId && hrLead == campus.hrLead && Objects.equals(buildings, campus.buildings) && Objects.equals(corporateEmployees, campus.corporateEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbrName, shippingAddress, trainingManagerId, stagingManagerId, hrLead, buildings, corporateEmployees);
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
            "}";
    }
}
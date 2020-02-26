package com.rms.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Building {

    @Id
    @SequenceGenerator(name="BuildingID_seq", sequenceName = "BuildingID_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BuildingID_seq")
    private int id;
    private String name;
    private String abbrName;
    private Address physicalAddress;
    private int trainingLead;
    private Amenity[] amenities;
    private Room[] rooms;
    private ResourceMetadata resourceMetadata;

    public Building() {
    }

    public Building(int id, String name, String abbrName, Address physicalAddress, int trainingLead, Amenity[] amenities, Room[] rooms, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.name = name;
        this.abbrName = abbrName;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
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

    public Address getPhysicalAddress() {
        return this.physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getTrainingLead() {
        return this.trainingLead;
    }

    public void setTrainingLead(int trainingLead) {
        this.trainingLead = trainingLead;
    }

    public Amenity[] getAmenities() {
        return this.amenities;
    }

    public void setAmenities(Amenity[] amenities) {
        this.amenities = amenities;
    }

    public Room[] getRooms() {
        return this.rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public ResourceMetadata getResourceMetadata() {
        return this.resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public Building id(int id) {
        this.id = id;
        return this;
    }

    public Building name(String name) {
        this.name = name;
        return this;
    }

    public Building abbrName(String abbrName) {
        this.abbrName = abbrName;
        return this;
    }

    public Building physicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }

    public Building trainingLead(int trainingLead) {
        this.trainingLead = trainingLead;
        return this;
    }

    public Building amenities(Amenity[] amenities) {
        this.amenities = amenities;
        return this;
    }

    public Building rooms(Room[] rooms) {
        this.rooms = rooms;
        return this;
    }

    public Building resourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Building)) {
            return false;
        }
        Building building = (Building) o;
        return id == building.id && Objects.equals(name, building.name) && Objects.equals(abbrName, building.abbrName) && Objects.equals(physicalAddress, building.physicalAddress) && trainingLead == building.trainingLead && Objects.equals(amenities, building.amenities) && Objects.equals(rooms, building.rooms) && Objects.equals(resourceMetadata, building.resourceMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbrName, physicalAddress, trainingLead, amenities, rooms, resourceMetadata);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", abbrName='" + getAbbrName() + "'" +
            ", physicalAddress='" + getPhysicalAddress() + "'" +
            ", trainingLead='" + getTrainingLead() + "'" +
            ", amenities='" + getAmenities() + "'" +
            ", rooms='" + getRooms() + "'" +
            ", resourceMetadata='" + getResourceMetadata() + "'" +
            "}";
    }

}
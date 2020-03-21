package com.revature.rms.campus.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.revature.rms.core.models.Resource;
import com.revature.rms.core.models.ResourceMetadata;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Document
@JsonPropertyOrder({
        "id",
        "name",
        "abbr",
        "physicalAddress",
        "trainingLead",
        "amenities",
        "rooms",
        "metadata"
})
public class Building extends Resource {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String abbr;

    @NotNull
    private Address physicalAddress;

    @NotNull @NotEmpty
    private String trainingLead;

    @NotNull
    private List<Amenity> amenities;

    @NotNull @NotEmpty
    private List<Room> rooms;

    public Building() {
        super();
        this.amenities = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Building(@NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address physicalAddress,
                    @NotNull @NotEmpty String trainingLead, @NotNull List<Amenity> amenities, @NotNull @NotEmpty List<Room> rooms) {
        this();
        this.name = name;
        this.abbr = abbr;
        this.physicalAddress = physicalAddress;
        this.trainingLead = trainingLead;
        this.amenities = amenities;
        this.rooms = rooms;
    }

    public Building(@NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address physicalAddress,
                    @NotNull @NotEmpty String trainingLead, @NotNull List<Amenity> amenities, @NotNull @NotEmpty List<Room> rooms,
                    ResourceMetadata metadata) {
        this(name, abbr, physicalAddress, trainingLead, amenities, rooms);
        this.metadata = metadata;
    }

    public Building(String id, @NotNull @NotEmpty String name, @NotNull @NotEmpty String abbr, @NotNull Address physicalAddress,
                    @NotNull @NotEmpty String trainingLead, @NotNull List<Amenity> amenities, @NotNull @NotEmpty List<Room> rooms,
                    ResourceMetadata metadata) {
        this(name, abbr, physicalAddress, trainingLead, amenities, rooms, metadata);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Building setName(String name) {
        this.name = name;
        return this;
    }

    public String getAbbr() {
        return abbr;
    }

    public Building setAbbr(String abbr) {
        this.abbr = abbr;
        return this;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public Building setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }

    public String getTrainingLead() {
        return trainingLead;
    }

    public Building setTrainingLead(String trainingLead) {
        this.trainingLead = trainingLead;
        return this;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public Building setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
        return this;
    }

    public Building addAmenities(Amenity... amenities) {
        this.amenities.addAll(Arrays.asList(amenities));
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Building setRooms(List<Room> rooms) {
        this.rooms = rooms;
        return this;
    }

    public Building addRooms(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return name.equals(building.name) &&
                abbr.equals(building.abbr) &&
                physicalAddress.equals(building.physicalAddress) &&
                trainingLead.equals(building.trainingLead) &&
                amenities.equals(building.amenities) &&
                rooms.equals(building.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abbr, physicalAddress, trainingLead, amenities, rooms);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", physicalAddress=" + physicalAddress +
                ", trainingLead='" + trainingLead + '\'' +
                ", amenities=" + amenities +
                ", rooms=" + rooms +
                ", metadata=" + metadata +
                '}';
    }

}

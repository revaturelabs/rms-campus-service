package com.revature.rms.campus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Document

//commentted out bc mangodb
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Data
public class Room {
    /**
     * May need to add @NotNull annotations to some fields to prevent null values.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String roomNumber;
    
    @Column(nullable=false)
    private int maxOccupancy;

    @Column(nullable=false)
    private boolean active;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
    private List<RoomStatus> roomStatus;

    @Column(nullable=false)
    private int batchId;

    @ElementCollection
    private List<Integer> workOrders;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ResourceMetadata resourceMetadata;

    @ManyToOne
    @JsonIgnore
    private Building building;

    public Room() {
    }

    public Room(int id, String roomNumber, Integer maxOccupancy, Boolean active, ArrayList<RoomStatus> roomStatus, int batchId, ArrayList<Integer> workOrders, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.active = active;
        this.roomStatus = roomStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

    public Room(String roomNumber, Integer maxOccupancy, Boolean active, ArrayList<RoomStatus> roomStatus, int batchId, ArrayList<Integer> workOrders, ResourceMetadata resourceMetadata) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.active = active;
        this.roomStatus = roomStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void addRoomStatus(RoomStatus status) {
        roomStatus.add(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RoomStatus> getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(List<RoomStatus> roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public List<Integer> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<Integer> workOrders) {
        this.workOrders = workOrders;
    }

    public ResourceMetadata getResourceMetadata() {
        return resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}

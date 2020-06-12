package com.revature.rms.campus.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
//@Document
@Data
//commentted out bc mangodb
//@NoArgsConstructor
//@AllArgsConstructor
public class Room {
    /**
     * May need to add @NotNull annotations to some fields to prevent null values.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    @Column(nullable=false)
    private String roomNumber;
    
    @Column(nullable=false)
    private Integer maxOccupancy;

    @Column(nullable=false)
    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private ArrayList <RoomStatus> roomStatus;

    @Column(nullable=false)
    private String batchId;

    @Column
    private ArrayList<String> workOrders;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private ResourceMetadata resourceMetadata;

    public Room() {
    }

    public Room(String id, String roomNumber, Integer maxOccupancy, Boolean active, ArrayList<RoomStatus> roomStatus, String batchId, ArrayList<String> workOrders, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.active = active;
        this.roomStatus = roomStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

    public Room(String roomNumber, Integer maxOccupancy, Boolean active, ArrayList<RoomStatus> roomStatus, String batchId, ArrayList<String> workOrders, ResourceMetadata resourceMetadata) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.active = active;
        this.roomStatus = roomStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

    public void addRoomStatus(RoomStatus status) {
        roomStatus.add(status);
    }
}

package com.revature.rms.campus.entities;

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
    private String id;

    @Column(nullable=false)
    private String roomNumber;
    
    @Column(nullable=false)
    private Integer maxOccupancy;

    @Column(nullable=false)
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private List<RoomStatus> roomStatus;

    @Column(nullable=false)
    private String batchId;

    @ElementCollection
    private List<String> workOrders;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // copy from building service?
    private ResourceMetadata resourceMetadata;

    @ManyToOne
    private Building building;

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

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void addRoomStatus(RoomStatus status) {
        roomStatus.add(status);
    }
}

package com.revature.rms.campus.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private String id;
    private String roomNumber;
    private Integer maxOccupancy;
    private Boolean isActive;
    private RoomStatus roomStatus;
    private Integer batchId;
    private ArrayList<Integer> workOrders;
    private ResourceMetadata resourceMetadata;

    public Room(String roomNumber, Integer maxOccupancy, Boolean isActive, RoomStatus roomStatus, Integer batchId, ArrayList<Integer> workOrders, ResourceMetadata resourceMetadata) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.roomStatus = roomStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }
}

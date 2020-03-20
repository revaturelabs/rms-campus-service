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
    /**
     * May need to add @NotNull annotations to some fields to prevent null values.
     */
    @Id
    private String id;
    private String roomNumber;
    private Integer maxOccupancy;
    private Boolean active;
    private ArrayList <RoomStatus> roomStatus;
    private String batchId;
    private ArrayList<String> workOrders;
    private ResourceMetadata resourceMetadata;

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

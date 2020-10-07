package com.rms.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Room {

    @Id
    @SequenceGenerator(name = "RoomID_seq", sequenceName = "RoomID_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoomID_seq")
    private int id;
    private String roomNumber;
    private int maxOccupancy;
    private boolean isActive;
    
    @OneToOne
    private RoomStatus currentStatus;
    private int batchId;
    private int[] workOrders;
    @OneToOne
    private ResourceMetadata resourceMetadata;

    public Room() {
    }

    public Room(int id, String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus, int batchId, int[] workOrders, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.currentStatus = currentStatus;
        this.batchId = batchId;
        this.workOrders = workOrders;
        this.resourceMetadata = resourceMetadata;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxOccupancy() {
        return this.maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public RoomStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(RoomStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int[] getWorkOrders() {
        return this.workOrders;
    }

    public void setWorkOrders(int[] workOrders) {
        this.workOrders = workOrders;
    }

    public ResourceMetadata getResourceMetadata() {
        return this.resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public Room id(int id) {
        this.id = id;
        return this;
    }

    public Room roomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public Room maxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
        return this;
    }

    public Room isActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Room currentStatus(RoomStatus currentStatus) {
        this.currentStatus = currentStatus;
        return this;
    }

    public Room batchId(int batchId) {
        this.batchId = batchId;
        return this;
    }

    public Room workOrders(int[] workOrders) {
        this.workOrders = workOrders;
        return this;
    }

    public Room resourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return id == room.id && Objects.equals(roomNumber, room.roomNumber) && maxOccupancy == room.maxOccupancy && isActive == room.isActive && Objects.equals(currentStatus, room.currentStatus) && batchId == room.batchId && Objects.equals(workOrders, room.workOrders) && Objects.equals(resourceMetadata, room.resourceMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, maxOccupancy, isActive, currentStatus, batchId, workOrders, resourceMetadata);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", roomNumber='" + getRoomNumber() + "'" +
            ", maxOccupancy='" + getMaxOccupancy() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", currentStatus='" + getCurrentStatus() + "'" +
            ", batchId='" + getBatchId() + "'" +
            ", workOrders='" + getWorkOrders() + "'" +
            ", resourceMetadata='" + getResourceMetadata() + "'" +
            "}";
    }
}
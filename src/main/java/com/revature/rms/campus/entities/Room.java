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
        "roomNumber",
        "maxOccupancy",
        "workOrders",
        "metadata"
})
public class Room extends Resource {

    @NotNull @NotEmpty
    private String roomNumber;

    @NotNull @NotEmpty
    private int maxOccupancy;

    @NotNull
    private List<String> workOrders;

    public Room() {
        super();
        this.workOrders = new ArrayList<>();
    }

    public Room(@NotNull @NotEmpty String roomNumber, @NotNull @NotEmpty int maxOccupancy, @NotNull List<String> workOrders) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.workOrders = workOrders;
    }

    public Room(String id, @NotNull @NotEmpty String roomNumber, @NotNull @NotEmpty int maxOccupancy,
                @NotNull List<String> workOrders, ResourceMetadata metadata) {
        super(id, metadata);
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.workOrders = workOrders;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Room setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public Room setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
        return this;
    }

    public List<String> getWorkOrders() {
        return workOrders;
    }

    public Room setWorkOrders(List<String> workOrders) {
        this.workOrders = workOrders;
        return this;
    }

    public Room addWorkOrders(String... workOrderIds) {
        this.workOrders.addAll(Arrays.asList(workOrderIds));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return maxOccupancy == room.maxOccupancy &&
                roomNumber.equals(room.roomNumber) &&
                workOrders.equals(room.workOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, maxOccupancy, workOrders);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", maxOccupancy=" + maxOccupancy +
                ", workOrders=" + workOrders +
                ", metadata=" + metadata +
                '}';
    }
}

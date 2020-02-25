package com.rms.model;

import java.util.Objects;

public class RoomStatus {
    private int id;
    private boolean whiteboardCleaned;
    private boolean chairOrdered;
    private boolean desksCleaned;
    private String submittedDateTime;
    private int submitterId;

    public RoomStatus() {
    }

    public RoomStatus(int id, boolean whiteboardCleaned, boolean chairOrdered, boolean desksCleaned, String submittedDateTime, int submitterId) {
        this.id = id;
        this.whiteboardCleaned = whiteboardCleaned;
        this.chairOrdered = chairOrdered;
        this.desksCleaned = desksCleaned;
        this.submittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWhiteboardCleaned() {
        return this.whiteboardCleaned;
    }

    public boolean getWhiteboardCleaned() {
        return this.whiteboardCleaned;
    }

    public void setWhiteboardCleaned(boolean whiteboardCleaned) {
        this.whiteboardCleaned = whiteboardCleaned;
    }

    public boolean isChairOrdered() {
        return this.chairOrdered;
    }

    public boolean getChairOrdered() {
        return this.chairOrdered;
    }

    public void setChairOrdered(boolean chairOrdered) {
        this.chairOrdered = chairOrdered;
    }

    public boolean isDesksCleaned() {
        return this.desksCleaned;
    }

    public boolean getDesksCleaned() {
        return this.desksCleaned;
    }

    public void setDesksCleaned(boolean desksCleaned) {
        this.desksCleaned = desksCleaned;
    }

    public String getSubmittedDateTime() {
        return this.submittedDateTime;
    }

    public void setSubmittedDateTime(String submittedDateTime) {
        this.submittedDateTime = submittedDateTime;
    }

    public int getSubmitterId() {
        return this.submitterId;
    }

    public void setSubmitterId(int submitterId) {
        this.submitterId = submitterId;
    }

    public RoomStatus id(int id) {
        this.id = id;
        return this;
    }

    public RoomStatus whiteboardCleaned(boolean whiteboardCleaned) {
        this.whiteboardCleaned = whiteboardCleaned;
        return this;
    }

    public RoomStatus chairOrdered(boolean chairOrdered) {
        this.chairOrdered = chairOrdered;
        return this;
    }

    public RoomStatus desksCleaned(boolean desksCleaned) {
        this.desksCleaned = desksCleaned;
        return this;
    }

    public RoomStatus submittedDateTime(String submittedDateTime) {
        this.submittedDateTime = submittedDateTime;
        return this;
    }

    public RoomStatus submitterId(int submitterId) {
        this.submitterId = submitterId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoomStatus)) {
            return false;
        }
        RoomStatus roomStatus = (RoomStatus) o;
        return id == roomStatus.id && whiteboardCleaned == roomStatus.whiteboardCleaned && chairOrdered == roomStatus.chairOrdered && desksCleaned == roomStatus.desksCleaned && Objects.equals(submittedDateTime, roomStatus.submittedDateTime) && submitterId == roomStatus.submitterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, whiteboardCleaned, chairOrdered, desksCleaned, submittedDateTime, submitterId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", whiteboardCleaned='" + isWhiteboardCleaned() + "'" +
            ", chairOrdered='" + isChairOrdered() + "'" +
            ", desksCleaned='" + isDesksCleaned() + "'" +
            ", submittedDateTime='" + getSubmittedDateTime() + "'" +
            ", submitterId='" + getSubmitterId() + "'" +
            "}";
    }

}
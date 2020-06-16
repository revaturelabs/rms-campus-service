package com.revature.rms.campus.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


//@Document

//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Data
public class RoomStatus {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private boolean whiteBoardCleaned;

    @Column(nullable=false)
    private boolean chairsOrdered;

    @Column(nullable=false)
    private String submittedDateTime;

    @Column(nullable=false)
    private int submitterId;

    @Column(nullable=false)
    private String otherNotes;

    @ManyToOne
    @JsonIgnore
    private Room room;

    @Column
    private boolean archived;

    public RoomStatus() {
    }

    public RoomStatus(int id, boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId, String otherNotes, boolean archived) {
        this.id = id;
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        this.submittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
        this.otherNotes = otherNotes;
        this.archived = archived;
    }

    public RoomStatus(boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId, String otherNotes, boolean archived) {
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        this.submittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
        this.otherNotes = otherNotes;
        this.archived = archived;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

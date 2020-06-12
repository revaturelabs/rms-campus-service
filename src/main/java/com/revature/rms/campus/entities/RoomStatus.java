package com.revature.rms.campus.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
//@Document
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class RoomStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private boolean whiteBoardCleaned;

    @Column(nullable=false)
    private boolean chairsOrdered;

    @Column(nullable=false)
    private String SubmittedDateTime;

    @Column(nullable=false)
    private int submitterId;

    @Column(nullable=false)
    private String otherNotes;

    @Column
    private boolean archived;

    public RoomStatus() {
    }

    public RoomStatus(int id, boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId, String otherNotes, boolean archived) {
        this.id = id;
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        SubmittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
        this.otherNotes = otherNotes;
        this.archived = archived;
    }

    public RoomStatus(boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId, String otherNotes, boolean archived) {
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        SubmittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
        this.otherNotes = otherNotes;
        this.archived = archived;
    }

}

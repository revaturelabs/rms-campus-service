package com.revature.rms.campus.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatus {
    @Id
    private Integer id;
    private boolean whiteBoardCleaned;
    private boolean chairsOrdered;
    private String SubmittedDateTime;
    private int submitterId;
    private String otherNotes;

    public RoomStatus(boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId, String otherNotes) {
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        SubmittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
        this.otherNotes = otherNotes;
    }

}

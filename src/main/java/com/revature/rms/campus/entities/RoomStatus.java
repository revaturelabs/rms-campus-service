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

    public RoomStatus(boolean whiteBoardCleaned, boolean chairsOrdered, String submittedDateTime, int submitterId) {
        this.whiteBoardCleaned = whiteBoardCleaned;
        this.chairsOrdered = chairsOrdered;
        SubmittedDateTime = submittedDateTime;
        this.submitterId = submitterId;
    }
}

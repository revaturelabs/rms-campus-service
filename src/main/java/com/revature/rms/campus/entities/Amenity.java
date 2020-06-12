package com.revature.rms.campus.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
//@Document
@Data
//commentted out bc mangodb
//@NoArgsConstructor
//@AllArgsConstructor
public class Amenity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Enumerated(EnumType.STRING)
    private AmenityType type;

    @Enumerated(EnumType.STRING)
    private AmenityStatus status;

    public Amenity() {
    }

    public Amenity(AmenityType type, AmenityStatus status) {
        this.type = type;
        this.status = status;
    }

    public Amenity(int id, AmenityType type, AmenityStatus status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }
}

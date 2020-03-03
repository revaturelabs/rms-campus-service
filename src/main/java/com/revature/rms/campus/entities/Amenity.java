package com.revature.rms.campus.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amenity {

    private AmenityType type;
    private AmenityStatus status;

}

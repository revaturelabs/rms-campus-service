package com.revature.rms.campus.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@ToString
//commentted out bc mangodb
//@AllArgsConstructor
//@NoArgsConstructor
public class ResourceMetadata {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false) //covert h2
    private int resourceCreator;
    
    @Column(nullable=false) //covert h2
    private String resourceCreatorDateTime;

    @Column(nullable=false) //covert h2
    private int lastModifier;

    @Column(nullable=false) //covert h2
    private String lastModifiedDateTime;

    @Column(nullable=false) //covert h2
    private int resourceOwner;

    public ResourceMetadata() {
    }

    public ResourceMetadata(int id, int resourceCreator, String resourceCreatorDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner) {
        this.id = id;
        this.resourceCreator = resourceCreator;
        this.resourceCreatorDateTime = resourceCreatorDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
    }

    public ResourceMetadata(String resourceCreatorDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner) {
        this.resourceCreatorDateTime = resourceCreatorDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
    }


}

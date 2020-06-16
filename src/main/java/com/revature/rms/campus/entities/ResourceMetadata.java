package com.revature.rms.campus.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
//commentted out bc mangodb
//@AllArgsConstructor
//@NoArgsConstructor
public class ResourceMetadata {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable=false) //covert h2
    private int resourceCreator;
    
    @Column(nullable=false) //covert h2
    private String resourceCreationDateTime;

    @Column(nullable=false) //covert h2
    private int lastModifier;

    @Column(nullable=false) //covert h2
    private String lastModifiedDateTime;

    @Column(nullable=false) //covert h2
    private int resourceOwner;

    @Column(nullable=false)
    private boolean isActive;

    public ResourceMetadata() {
    }

    public ResourceMetadata(int id, int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean isActive) {
        this.id = id;
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.isActive = isActive;
    }

    public ResourceMetadata(int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean isActive) {
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.isActive = isActive;
    }

    public ResourceMetadata(String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean isActive) {
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.isActive = isActive;
    }
}

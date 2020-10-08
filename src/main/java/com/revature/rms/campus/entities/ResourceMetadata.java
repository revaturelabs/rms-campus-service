package com.revature.rms.campus.entities;


import lombok.*;

import javax.persistence.*;

@Embeddable
@Data
//commentted out bc mangodb
//@AllArgsConstructor
//@NoArgsConstructor
public class ResourceMetadata {

//    @Id
//    @Column
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private int id;
    
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
    private boolean currentlyActive;

    public ResourceMetadata() {
    }

    public ResourceMetadata(int id, int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
//        this.id = id;
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.currentlyActive = currentlyActive;
    }

    public ResourceMetadata(int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.currentlyActive = currentlyActive;
    }

    public ResourceMetadata(String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.currentlyActive = currentlyActive;
    }

    public boolean isCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public int getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(int resourceOwner) {
        this.resourceOwner = resourceOwner;
    }
}

package com.revature.rms.campus.entities;


import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ResourceMetadataEmbeddable {

//    //old code
//    @Id
//    @Column
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private int id;
//    //end old code

    //new code
    //end new code

    //@Column(nullable=false) //covert h2
    private int resourceCreator;

    //    @Column(nullable=false) //covert h2
    private String resourceCreationDateTime;

    //    @Column(nullable=false) //covert h2
    private int lastModifier;

    //    @Column(nullable=false) //covert h2
    private String lastModifiedDateTime;

    //    @Column(nullable=false) //covert h2
    private int resourceOwner;

    //    @Column(nullable=false)
    private boolean currentlyActive;

    public ResourceMetadataEmbeddable() {
    }


    public ResourceMetadataEmbeddable(int id, int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
//    //old code
//        this.id = id;
//    //end old code
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.currentlyActive = currentlyActive;
    }


    //new code
    //end new code

    public ResourceMetadataEmbeddable(int resourceCreator, String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
        this.resourceCreator = resourceCreator;
        this.resourceCreationDateTime = resourceCreationDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
        this.currentlyActive = currentlyActive;
    }

    public ResourceMetadataEmbeddable(String resourceCreationDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner, boolean currentlyActive) {
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

//    //old code
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//    //end old code

    //new code
    //end new code

    public int getResourceOwner() {
        return resourceOwner;
    }

    public void setResourceOwner(int resourceOwner) {
        this.resourceOwner = resourceOwner;
    }
}

package com.revature.rms.campus.entities;


import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResourceMetadata {

    private int resourceCreator;
    private String resourceCreatorDateTime;
    private int lastModifier;
    private String lastModifiedDateTime;
    private int resourceOwner;

    public ResourceMetadata(String resourceCreatorDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner) {
        this.resourceCreatorDateTime = resourceCreatorDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
    }


}

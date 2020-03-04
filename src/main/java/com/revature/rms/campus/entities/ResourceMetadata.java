package com.revature.rms.campus.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

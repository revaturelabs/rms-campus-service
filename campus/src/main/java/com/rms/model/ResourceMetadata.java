package com.rms.model;

import java.util.Objects;

public class ResourceMetadata{
    private int resourceCreator;
    private String resourceCreatorDateTime;
    private int lastModifier;
    private String lastModifiedDateTime;
    private int resourceOwner;

    public ResourceMetadata() {
    }

    public ResourceMetadata(int resourceCreator, String resourceCreatorDateTime, int lastModifier, String lastModifiedDateTime, int resourceOwner) {
        this.resourceCreator = resourceCreator;
        this.resourceCreatorDateTime = resourceCreatorDateTime;
        this.lastModifier = lastModifier;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.resourceOwner = resourceOwner;
    }

    public int getResourceCreator() {
        return this.resourceCreator;
    }

    public void setResourceCreator(int resourceCreator) {
        this.resourceCreator = resourceCreator;
    }

    public String getResourceCreatorDateTime() {
        return this.resourceCreatorDateTime;
    }

    public void setResourceCreatorDateTime(String resourceCreatorDateTime) {
        this.resourceCreatorDateTime = resourceCreatorDateTime;
    }

    public int getLastModifier() {
        return this.lastModifier;
    }

    public void setLastModifier(int lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getLastModifiedDateTime() {
        return this.lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public int getResourceOwner() {
        return this.resourceOwner;
    }

    public void setResourceOwner(int resourceOwner) {
        this.resourceOwner = resourceOwner;
    }

    public ResourceMetadata resourceCreator(int resourceCreator) {
        this.resourceCreator = resourceCreator;
        return this;
    }

    public ResourceMetadata resourceCreatorDateTime(String resourceCreatorDateTime) {
        this.resourceCreatorDateTime = resourceCreatorDateTime;
        return this;
    }

    public ResourceMetadata lastModifier(int lastModifier) {
        this.lastModifier = lastModifier;
        return this;
    }

    public ResourceMetadata lastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
        return this;
    }

    public ResourceMetadata resourceOwner(int resourceOwner) {
        this.resourceOwner = resourceOwner;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResourceMetadata)) {
            return false;
        }
        ResourceMetadata resourceMetadata = (ResourceMetadata) o;
        return resourceCreator == resourceMetadata.resourceCreator && Objects.equals(resourceCreatorDateTime, resourceMetadata.resourceCreatorDateTime) && lastModifier == resourceMetadata.lastModifier && Objects.equals(lastModifiedDateTime, resourceMetadata.lastModifiedDateTime) && resourceOwner == resourceMetadata.resourceOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceCreator, resourceCreatorDateTime, lastModifier, lastModifiedDateTime, resourceOwner);
    }

    @Override
    public String toString() {
        return "{" +
            " resourceCreator='" + getResourceCreator() + "'" +
            ", resourceCreatorDateTime='" + getResourceCreatorDateTime() + "'" +
            ", lastModifier='" + getLastModifier() + "'" +
            ", lastModifiedDateTime='" + getLastModifiedDateTime() + "'" +
            ", resourceOwner='" + getResourceOwner() + "'" +
            "}";
    }
}
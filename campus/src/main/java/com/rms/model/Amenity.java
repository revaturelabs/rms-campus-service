package com.rms.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Amenity {
    private AmenityType type;
    private AmenityStatus status;

    public Amenity() {
    }

    public Amenity(AmenityType type, AmenityStatus status) {
        this.type = type;
        this.status = status;
    }

    public AmenityType getType() {
        return this.type;
    }

    public void setType(AmenityType type) {
        this.type = type;
    }

    public AmenityStatus getStatus() {
        return this.status;
    }

    public void setStatus(AmenityStatus status) {
        this.status = status;
    }

    public Amenity type(AmenityType type) {
        this.type = type;
        return this;
    }

    public Amenity status(AmenityStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Amenity)) {
            return false;
        }
        Amenity amenity = (Amenity) o;
        return Objects.equals(type, amenity.type) && Objects.equals(status, amenity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, status);
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

}
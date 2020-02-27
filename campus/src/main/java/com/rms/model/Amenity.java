package com.rms.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Amenity {

    @Id
    @SequenceGenerator(name = "AmenityID_seq", sequenceName = "AmenityID_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AmenityID_seq")
    private int id;
    private AmenityType type;
    private AmenityStatus status;

    public Amenity() {
    }

    public Amenity(int id, AmenityType type, AmenityStatus status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Amenity id(int id) {
        this.id = id;
        return this;
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
        return id == amenity.id && Objects.equals(type, amenity.type) && Objects.equals(status, amenity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, status);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

   

}
package com.revature.rms.campus.entities;

public class Amenity {

    private String type;
    private AmenityStatus status;

    public Amenity() {
        super();
    }

    public Amenity(String type, AmenityStatus status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public Amenity setType(String type) {
        this.type = type;
        return this;
    }

    public AmenityStatus getStatus() {
        return status;
    }

    public Amenity setStatus(AmenityStatus status) {
        this.status = status;
        return this;
    }

}

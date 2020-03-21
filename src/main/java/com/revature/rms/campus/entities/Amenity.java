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

}

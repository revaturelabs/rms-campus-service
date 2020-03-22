package com.revature.rms.campus.documents;

public enum AmenityStatus {

    OK("Ok - Stocked for 2+ weeks"),
    LOW("Low - Less than 2 week supply left"),
    OUT("Out - Restock ASAP");

    private String description;

    AmenityStatus(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        return this.description;
    }

}

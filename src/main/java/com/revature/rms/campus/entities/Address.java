package com.revature.rms.campus.entities;

public class Address {

    private String unitStreet;
    private String city;
    private String state;
    private String zip;
    private Country country;

    public Address() {
        super();
    }

    public Address(String unitStreet, String city, String state, String zip, Country country) {
        this.unitStreet = unitStreet;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getUnitStreet() {
        return unitStreet;
    }

    public Address setUnitStreet(String unitStreet) {
        this.unitStreet = unitStreet;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Address setCountry(Country country) {
        this.country = country;
        return this;
    }

    public enum Country {
        USA, CANADA, INDIA;
    }

}

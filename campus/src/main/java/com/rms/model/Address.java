package com.rms.model;

import java.util.Objects;

public class Address{
    private String unitStreet;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String unitStreet, String city, String state, String zip, String country) {
        this.unitStreet = unitStreet;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getUnitStreet() {
        return this.unitStreet;
    }

    public void setUnitStreet(String unitStreet) {
        this.unitStreet = unitStreet;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address unitStreet(String unitStreet) {
        this.unitStreet = unitStreet;
        return this;
    }

    public Address city(String city) {
        this.city = city;
        return this;
    }

    public Address state(String state) {
        this.state = state;
        return this;
    }

    public Address zip(String zip) {
        this.zip = zip;
        return this;
    }

    public Address country(String country) {
        this.country = country;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(unitStreet, address.unitStreet) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitStreet, city, state, zip, country);
    }

    @Override
    public String toString() {
        return "{" +
            " unitStreet='" + getUnitStreet() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", zip='" + getZip() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
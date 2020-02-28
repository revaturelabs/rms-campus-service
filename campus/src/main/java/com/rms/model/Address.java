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
public class Address{

    @Id
    @SequenceGenerator(name = "AddressID_seq", sequenceName = "AddressID_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressID_seq")
    private int id;
    private String unitStreet;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(int id, String unitStreet, String city, String state, String zip, String country) {
        this.id = id;
        this.unitStreet = unitStreet;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address id(int id) {
        this.id = id;
        return this;
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
        return id == address.id && Objects.equals(unitStreet, address.unitStreet) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitStreet, city, state, zip, country);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", unitStreet='" + getUnitStreet() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", zip='" + getZip() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }


}
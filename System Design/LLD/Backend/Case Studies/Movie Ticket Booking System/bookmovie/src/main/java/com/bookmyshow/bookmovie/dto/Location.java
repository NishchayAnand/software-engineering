package com.bookmyshow.bookmovie.dto;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Location {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public Location() {}

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public Location(String street, String city, String state, String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }



}

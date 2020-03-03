package com.revature.rms.campus.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    private String unitStreet;
    private String city;
    private String state;
    private String zip;
    private String country;

}

package com.example.app.model;

import com.example.app.validator.City;
import com.example.app.validator.Street;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ADDRESS_CONTACT")
public class AddressContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 1, message = "The smallest building number is {value}!")
    @Max(value = 999, message = "The greatest building number is {value}!")
    private long buildingNumber;

    @Min(value = 1, message = "The smallest flat number is {value}!")
    @Max(value = 999, message = "The greatest flat number is {value}!")
    private long flatNumber;

    @NotBlank
    @Street
    private String street;

    @NotBlank
    @City
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Invalid ZIP CODE value!")
    private String zipCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(long buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Long getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(long flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

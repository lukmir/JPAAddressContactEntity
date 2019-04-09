package com.example.app.validator;

public enum StreetEnum {
    AND("Andrychowska"),
    BAR("Bardosa"),
    HEM("Hemara Mariana"),
    HUB("Hubalczyków");
    
    private final String street;
    
    StreetEnum(String street) {
        this.street = street;
    }
    
    public String getStreet() {
        return street;
    }
}

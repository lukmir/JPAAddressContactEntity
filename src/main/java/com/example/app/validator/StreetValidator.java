package com.example.app.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StreetValidator implements ConstraintValidator<Street, String> {

    @Override
    public boolean isValid(String street, ConstraintValidatorContext cvc) {
        cvc.disableDefaultConstraintViolation();
        List<String> streetList = Stream.of(StreetEnum.values()).map(StreetEnum::getStreet).collect(Collectors.toList());   
        String availableStreets = streetList.toString().substring(1, streetList.toString().length() - 1);
        cvc.buildConstraintViolationWithTemplate("You can use street from following values: " + availableStreets + "!").addConstraintViolation();
        
        return streetList.contains(street);
    }
    
}

package com.example.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<City, String>{

    @Override
    public boolean isValid(String city, ConstraintValidatorContext cvc) {
        boolean finalUpperCaseFlag = true;
        String[] words = city.split(" ");
        for (String word : words) {
           finalUpperCaseFlag = Character.isUpperCase(word.charAt(0));
        }
        
        return finalUpperCaseFlag;
    }
    
}

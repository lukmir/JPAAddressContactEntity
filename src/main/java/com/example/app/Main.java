package com.example.app;

import com.example.app.model.AddressContact;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "ContactAddressWebAppPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager(); 
        
        AddressContact addressContact = new AddressContact();
        addressContact.setBuildingNumber(-1);
        addressContact.setCity("kielce");
        addressContact.setFlatNumber(1000);
        addressContact.setStreet("Hemara Mariana2");
        addressContact.setZipCode("1a-450");
        
        System.out.println("\nProgrammatic validation\n");       
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();        
        Set<ConstraintViolation<AddressContact>> errors = validator.validate(addressContact);
        errors.forEach(error -> System.out.println(error.getPropertyPath() + " " + error.getMessage()));
        
        
        System.out.println("\nJPA validation\n");  
        em.getTransaction().begin();
        em.persist(addressContact);
        em.getTransaction().commit();
        em.close();       
        
    }
}
package com.cources.finalProject.exceptions;

import com.cources.finalProject.model.dto.PersonDTO;
import com.cources.finalProject.model.entities.Person;

public class NotUniqueRegisterException extends RuntimeException {
    private Person person;

    public NotUniqueRegisterException(Person person, String message) {
        super(message);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}

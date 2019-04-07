package com.cources.finalProject.exceptions;

import com.cources.finalProject.model.entities.Person;

/**
 * Throws when user is already exist in DB
 */
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

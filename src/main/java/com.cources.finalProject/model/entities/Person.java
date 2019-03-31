package com.cources.finalProject.model.entities;

import java.util.Objects;

public class Person {
    private Long personId;
    private String login;
    private String email;
    private String password;
    private Role role;

    public static class PersonBuilder {
        private Long personId;
        private String login;
        private String email;
        private String password;
        private Role role;

        public PersonBuilder setPersonId(Long personId) {
            this.personId = personId;
            return this;
        }
        public PersonBuilder setLogin(String login) {
            this.login = login;
            return this;
        }
        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public PersonBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public PersonBuilder setRole(Role role) {
            this.role = role;
            return this;
        }
        public Person build() {
            return new Person(this);
        }
    }

    private Person(PersonBuilder builder) {
        this.personId = builder.personId;
        this.login = builder.login;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public void setPersonId(Long personId) { this.personId = personId; }

    public Long getPersonId() {
        return personId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getLogin(), person.getLogin()) &&
                getRole() == person.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getRole());
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

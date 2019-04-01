package com.cources.finalProject.model.dto;

import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;

public class PersonDTO {
    private String login;
    private String email;
    private String password;
    private Role role;

    public static class PersonDTOBuilder {
        private String login;
        private String email;
        private String password;
        private Role role;

        public PersonDTOBuilder setLogin(String login) {
            this.login = login;
            return this;
        }
        public PersonDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public PersonDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public PersonDTOBuilder setRole(Role role) {
            this.role = role;
            return this;
        }
        public PersonDTO build() {
            return new PersonDTO(this);
        }
    }

    private PersonDTO(PersonDTOBuilder builder) {
        this.login = builder.login;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    //Must be in another place!!!!!
    public static Person getPersonFromDto(PersonDTO dto) {
        return new Person.PersonBuilder()
                .setLogin(dto.login)
                .setEmail(dto.email)
                .setPassword(dto.password)
                .setRole(dto.role)
                .build();
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

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }
}

package com.cources.finalProject.model.entities;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO Find out where to store password hasher
public class Person {
    private Long personId;
    private String login;
    private String email;
    private String password;
    private Role role;

    private List<OrderRequest> userRequests = new ArrayList<>();
    private List<OrderRequest> managerRequests = new ArrayList<>();
    private List<Order> masterOrders = new ArrayList<>();

    public static class PersonBuilder {
        private Long personId;
        private String login;
        private String email;
        private String password;
        private Role role;
        private List<OrderRequest> userRequests;
        private List<OrderRequest> managerRequests;
        private List<Order> masterOrders;


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
            //this.password = hashPassword(password);
            this.password = password;
            return this;
        }
        public PersonBuilder setRole(Role role) {
            this.role = role;
            return this;
        }
        public PersonBuilder setUserRequests(List<OrderRequest> requests) {
            this.userRequests = requests;
            return this;
        }
        public PersonBuilder setManagetRequests(List<OrderRequest> requests) {
            this.managerRequests = requests;
            return this;
        }
        public PersonBuilder setMasterOrders(List<Order> orders) {
            this.masterOrders = masterOrders;
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

    public Person(Long personId) {
        this.personId = personId;
    }

    /*private static String hashPassword(String textPassword) {
        return BCrypt.hashpw(textPassword, BCrypt.gensalt(12));
    }*/

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
        //this.password = hashPassword(password);
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<OrderRequest> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(List<OrderRequest> userRequests) {
        this.userRequests = userRequests;
    }

    public List<OrderRequest> getManagerRequests() {
        return managerRequests;
    }

    public void setManagerRequests(List<OrderRequest> managerRequests) {
        this.managerRequests = managerRequests;
    }

    public List<Order> getMasterOrders() {
        return masterOrders;
    }

    public void setMasterOrders(List<Order> masterOrders) {
        this.masterOrders = masterOrders;
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

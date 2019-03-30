package com.cources.finalProject.models.dao.impl;

import com.cources.finalProject.models.dao.mapper.PersonMapper;
import com.cources.finalProject.models.dao.specificdao.PersonDAO;
import com.cources.finalProject.models.entities.Person;
import com.cources.finalProject.models.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCPersonDAO implements PersonDAO {

    private static final String GET_ALL_QUERY = "select * from person";
    private static final String GET_BY_ID_QUERY = "select * from person where person_id=?";
    private static final String CREATE_QUERY = "insert into person (login, email, password, role) values (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "update person set login=?, email=?, password=?," +
            " password=? where person_id=?";
    private static final String DELETE_QUERY = "delete * from person where id=?";
    private static final String GET_ALL_BY_ROLE_QUERY = "select * from person where role=?";
    private static final String GET_BY_LOGIN_QUERY = "select * from person where login=?";
    private static final String GET_BY_EMAIL_QUERY = "select * from person where email=?";

    private Connection connection;

    public JDBCPersonDAO(Connection connection) {
        this.connection = connection;
    }

    private Person getPersonFromStatement(PreparedStatement statement) {
        try (ResultSet rs = statement.executeQuery()) {
            PersonMapper personMapper = new PersonMapper();
            Person person = null;
            if (rs.next()) {
                person = personMapper.extractFromResultSet(rs);
            }
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAllByRole(Role role) {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_ROLE_QUERY)) {
            statement.setString(1, role.toString());
            try (ResultSet rs = statement.executeQuery(GET_ALL_BY_ROLE_QUERY)) {
                PersonMapper personMapper = new PersonMapper();
                while (rs.next()) {
                    Person person = personMapper.extractFromResultSet(rs);
                    personList.add(person);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public Person getByLogin(String login) {
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_LOGIN_QUERY)) {
            statement.setString(1, login);
            return getPersonFromStatement(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person getByEmail(String email) {
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL_QUERY)) {
            statement.setString(1, email);
            return getPersonFromStatement(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Person entity) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_QUERY)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPassword());
            statement.setString(4, entity.getRole().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_QUERY)) {
            PersonMapper personMapper = new PersonMapper();
            while (rs.next()) {
                Person person = personMapper.extractFromResultSet(rs);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public Person getById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_ID_QUERY)) {
            statement.setInt(1, id);
            return getPersonFromStatement(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Person entity) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPassword());
            statement.setLong(4, entity.getPersonId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setLong(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.cources.finalProject.model.dao.impl;

import com.cources.finalProject.exceptions.DBRequestException;
import com.cources.finalProject.exceptions.NotUniqueRegisterException;
import com.cources.finalProject.model.dao.JDBCTemplate;
import com.cources.finalProject.model.dao.mapper.PersonMapper;
import com.cources.finalProject.model.dao.specificdao.PersonDAO;
import com.cources.finalProject.model.entities.Person;
import com.cources.finalProject.model.entities.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Person DAO implements for JDBC
 */
public class JDBCPersonDAO implements PersonDAO {

    private static Logger logger = LoggerFactory.getLogger(JDBCPersonDAO.class);

    private static final String GET_ALL_QUERY = "select * from person";
    private static final String GET_BY_ID_QUERY = "select * from person where person_id=?";
    private static final String CREATE_QUERY = "insert into person (login, email, password, role_id) values (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "update person set login=?, email=?, password=?," +
            " role_id=? where person_id=?";
    private static final String DELETE_QUERY = "delete from person where person_id=?";
    private static final String GET_ALL_BY_ROLE_QUERY = "select * from person where role_id=?";
    private static final String GET_BY_LOGIN_QUERY = "select * from person where login=?";
    private static final String GET_BY_EMAIL_QUERY = "select * from person where email=?";
    private static final String GET_BY_LOGIN_OR_EMAIL_QUERY = "select * from person where email=? or login=?";

    private DataSource dataSource;

    public JDBCPersonDAO(DataSource dataSource) {
        this.dataSource = dataSource;
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
            logger.error("Couldn't get person statement", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> getAllByRole(Role role) {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = JDBCTemplate.prepareQuery(connection,
                        GET_ALL_BY_ROLE_QUERY, role.ordinal())) {
            try (ResultSet rs = statement.executeQuery()) {
                PersonMapper personMapper = new PersonMapper();
                while (rs.next()) {
                    Person person = personMapper.extractFromResultSet(rs);
                    personList.add(person);
                }
            }
        } catch (SQLException e) {
            logger.error("In getAllByRole", e);
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public Optional<Person> getByLogin(String login) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, GET_BY_LOGIN_QUERY, login)) {
            return Optional.ofNullable(getPersonFromStatement(statement));
        } catch (SQLException e) {
            logger.error("In getByLogin", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Person> getByEmail(String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, GET_BY_EMAIL_QUERY, email)) {
            return Optional.ofNullable(getPersonFromStatement(statement));
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new DBRequestException(e);
        }
    }

    @Override
    public Optional<Person> getByLoginOrEmail(String loginOrEmail) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, GET_BY_LOGIN_OR_EMAIL_QUERY,
                     loginOrEmail, loginOrEmail)) {
            return Optional.ofNullable(getPersonFromStatement(statement));
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new DBRequestException(e);
        }
    }

    @Override
    public void create(Person entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, CREATE_QUERY, entity.getLogin(),
                entity.getEmail(), entity.getPassword(), entity.getRole().ordinal())) {

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Couldn't create Person entity", entity, e);
            throw new NotUniqueRegisterException(entity, "This login or email is already busy, choose another one");
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(GET_ALL_QUERY)) {
            System.out.println(connection);
            PersonMapper personMapper = new PersonMapper();
            while (rs.next()) {
                Person person = personMapper.extractFromResultSet(rs);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new DBRequestException(e);
        }
        return personList;
    }

    @Override
    public Optional<Person> getById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, GET_BY_ID_QUERY, id)) {
            return Optional.ofNullable(getPersonFromStatement(statement));
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new DBRequestException(e);
        }
    }

    @Override
    public void update(Person entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, UPDATE_QUERY,
                entity.getLogin(), entity.getEmail(), entity.getPassword(),
                     entity.getRole().ordinal(), entity.getPersonId())) {
            statement.executeUpdate();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new DBRequestException(e);
        }
    }

    @Override
    public void delete(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, DELETE_QUERY, id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            throw new DBRequestException(e);
        }
    }
}

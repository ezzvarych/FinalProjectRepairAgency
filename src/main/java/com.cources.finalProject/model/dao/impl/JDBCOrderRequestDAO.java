package com.cources.finalProject.model.dao.impl;

import com.cources.finalProject.exceptions.DBRequestException;
import com.cources.finalProject.exceptions.NotUniqueRegisterException;
import com.cources.finalProject.model.dao.JDBCTemplate;
import com.cources.finalProject.model.dao.mapper.OrderRequestMapper;
import com.cources.finalProject.model.dao.mapper.PersonMapper;
import com.cources.finalProject.model.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.model.entities.OrderRequest;
import com.cources.finalProject.model.entities.Person;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCOrderRequestDAO implements OrderRequestDAO {

    private static final String GET_ALL_REQUESTS_QUERY = "select * from request";
    private static final String GET_REQUEST_BY_ID_QUERY = "select * from request where request_id=?";
    private static final String GET_ALL_BY_USER_QUERY = "select * from request where user_id=?";
    private static final String CREATE_QUERY = "insert into request (user_id, description, request_time)" +
            " values (?, ?, NOW())";



    private DataSource dataSource;

    public JDBCOrderRequestDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<OrderRequest> getAllByManager(Person manager) {
        return null;
    }

    @Override
    public List<OrderRequest> getAllByUser(Person user) {
        List<OrderRequest> requests = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection,
                     GET_ALL_BY_USER_QUERY, user.getPersonId())) {

            try (ResultSet rs = statement.executeQuery()) {
                OrderRequestMapper orderRequestMapper = new OrderRequestMapper();
                while (rs.next()) {
                    OrderRequest orderRequest = orderRequestMapper.extractFromResultSet(rs);
                    requests.add(orderRequest);
                }
                return requests;
            }
        } catch (SQLException e) {
            throw new DBRequestException(e);
        }
    }

    @Override
    public List<OrderRequest> getAllAccepted() {
        return null;
    }

    @Override
    public List<OrderRequest> getAllDenied() {
        return null;
    }

    @Override
    public void create(OrderRequest entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = JDBCTemplate.prepareQuery(connection, CREATE_QUERY,
                     entity.getUser().getPersonId(), entity.getRequestDescr())) {

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBRequestException(e);
        }
    }

    @Override
    public List<OrderRequest> getAll() {
        return null;
    }

    @Override
    public Optional<OrderRequest> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void update(OrderRequest entity) {

    }

    @Override
    public void delete(long id) {

    }
}

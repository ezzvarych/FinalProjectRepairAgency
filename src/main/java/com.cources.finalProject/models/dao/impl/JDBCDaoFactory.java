package com.cources.finalProject.models.dao.impl;

import com.cources.finalProject.models.dao.DAOFactory;
import com.cources.finalProject.models.dao.specificdao.FeedbackDAO;
import com.cources.finalProject.models.dao.specificdao.OrderDAO;
import com.cources.finalProject.models.dao.specificdao.OrderRequestDAO;
import com.cources.finalProject.models.dao.specificdao.PersonDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DAOFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PersonDAO createPersonDao() {
        return new JDBCPersonDAO(getConnection());
    }

    @Override
    public OrderRequestDAO createOrderRequestDao() {
        return null;
    }

    @Override
    public OrderDAO createOrderDao() {
        return null;
    }

    @Override
    public FeedbackDAO createFeedbackDao() {
        return null;
    }
}

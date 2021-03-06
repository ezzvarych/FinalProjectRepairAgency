package com.cources.finalProject.model.dao.impl;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * Singleton, create connection pool if absent
 */
public class ConnectionPoolHolder {
    private static Logger logger = LoggerFactory.getLogger(ConnectionPoolHolder.class);

    private static volatile DataSource dataSource;

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/agencydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    logger.info("Created instance of ConnectionPool");
                    BasicDataSource basicDataSource = new BasicDataSource();
                    basicDataSource.setDriverClassName(DRIVER_CLASS);
                    basicDataSource.setUrl(CONNECTION_STRING);
                    basicDataSource.setUsername(USERNAME);
                    basicDataSource.setPassword(PASSWORD);
                    basicDataSource.setMinIdle(5);
                    basicDataSource.setMaxIdle(100);
                    basicDataSource.setMaxOpenPreparedStatements(100);
                    dataSource = basicDataSource;
                }
            }
        }
        return dataSource;
    }
}

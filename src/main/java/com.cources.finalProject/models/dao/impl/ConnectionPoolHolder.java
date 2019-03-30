package com.cources.finalProject.models.dao.impl;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/agencydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource basicDataSource = new BasicDataSource();
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
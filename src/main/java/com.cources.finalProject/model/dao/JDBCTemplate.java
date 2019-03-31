package com.cources.finalProject.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class make work with JDBC prepared statement simpler
 */
public class JDBCTemplate {
    /**
     * Insert arguments to prepared statement
     * @param connection
     * @param sql - prepared statement string
     * @param values - prepared statement params
     * @return ready to use prepared statement
     * @throws SQLException
     */
    public static PreparedStatement prepareQuery(Connection connection, String sql, Object... values) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
        return statement;
    }
}

package com.cources.finalProject.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Interface for all SQL query to entities mappers
 * @param <T>
 */
public interface ObjectMapper<T> {
    /**
     * Get entity from ResultSet row
     * @param rs
     * @return
     * @throws SQLException
     */
    T extractFromResultSet(ResultSet rs) throws SQLException;

    /**
     * For one-to-many, many-to-many requests to save extra-memory
     * @param cache
     * @param entity
     * @return
     */
    T makeUnique(Map<Long, T> cache, T entity);
}

package com.cources.finalProject.model.dao.mapper;

import com.cources.finalProject.model.entities.OrderRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderRequestMapper implements ObjectMapper<OrderRequest> {

    @Override
    public OrderRequest extractFromResultSet(ResultSet rs) throws SQLException {
        OrderRequest request = new OrderRequest.OrderRequestBuilder()
                .setRequestId(rs.getLong("request_id"))
                .setRequestDescr(rs.getString("description"))
                .setRequestDate(rs.getDate("request_time"))
                .setDenied(rs.getBoolean("is_denied"))
                .setDenyReason(rs.getString("deny_reason"))
                .build();
        return request;
    }

    @Override
    public OrderRequest makeUnique(Map<Long, OrderRequest> cache, OrderRequest entity) {
        cache.putIfAbsent(entity.getRequestId(), entity);
        return cache.get(entity.getRequestId());
    }
}

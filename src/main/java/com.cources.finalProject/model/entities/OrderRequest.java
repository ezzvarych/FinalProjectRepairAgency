package com.cources.finalProject.model.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Date;

/**
 * Contain user requests about order which should
 * be consider by manager
 */
//TODO Add builders to entities
public class OrderRequest {
    private Long requestId;
    private Person user;
    private String requestDescr;
    private Person manager;
    private Date requestDate;
    private Boolean isDenied;
    private String denyReason;

    public static class OrderRequestBuilder {
        private Long requestId;
        private Person user;
        private String requestDescr;
        private Person manager;
        private Date requestDate;
        private Boolean isDenied;
        private String denyReason;

        public OrderRequestBuilder setRequestId(long id) {
            this.requestId = id;
            return this;
        }

        public OrderRequestBuilder setUser(Person user) {
            this.user = user;
            return this;
        }

        public OrderRequestBuilder setRequestDescr(String requestDescr) {
            this.requestDescr = requestDescr;
            return this;
        }

        public OrderRequestBuilder setManager(Person manager) {
            this.manager = manager;
            return this;
        }

        public OrderRequestBuilder setRequestDate(Date requestDate) {
            this.requestDate = requestDate;
            return this;
        }

        public OrderRequestBuilder setDenied(Boolean denied) {
            isDenied = denied;
            return this;
        }

        public OrderRequestBuilder setDenyReason(String denyReason) {
            this.denyReason = denyReason;
            return this;
        }

        public OrderRequest build() {
            return new OrderRequest(this);
        }
    }

    private OrderRequest(OrderRequestBuilder builder) {
        this.requestId = builder.requestId;
        this.user = builder.user;
        this.requestDescr = builder.requestDescr;
        this.manager = builder.manager;
        this.requestDate = builder.requestDate;
        this.isDenied = builder.isDenied;
        this.denyReason = builder.denyReason;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "requestId=" + requestId +
                ", user=" + user +
                ", requestDescr='" + requestDescr + '\'' +
                ", manager=" + manager +
                ", requestDate=" + requestDate +
                ", isDenied=" + isDenied +
                ", denyReason='" + denyReason + '\'' +
                '}';
    }

    public void setRequestId(long requestId) { this.requestId = requestId; }

    public long getRequestId() { return requestId; }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public String getRequestDescr() {
        return requestDescr;
    }

    public void setRequestDescr(String requestDescr) {
        this.requestDescr = requestDescr;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean isDenied() {
        return isDenied;
    }

    public void setDenied(Boolean denied) {
        isDenied = denied;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }
}

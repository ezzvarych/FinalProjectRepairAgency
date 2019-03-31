package com.cources.finalProject.model.entities;

import java.sql.Date;

//TODO Add builders to entities
public class OrderRequest {
    private Long requestId;
    private Person user;
    private String requestDescr;
    private Person manager;
    private Date requestDate;
    private boolean isDenied;
    private String denyReason;

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

    public boolean isDenied() {
        return isDenied;
    }

    public void setDenied(boolean denied) {
        isDenied = denied;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }
}

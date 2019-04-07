package com.cources.finalProject.model.entities;

/**
 * Entity for user orders
 */
//TODO Add builders to entities
public class Order {
    private OrderRequest orderRequest;
    private Person master;
    private int price;
    private boolean isDone;

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public Person getMaster() {
        return master;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

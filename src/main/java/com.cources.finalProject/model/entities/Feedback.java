package com.cources.finalProject.model.entities;

/**
 * Entity for user feedbacks
 */
public class Feedback {
    private Order order;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

package com.techchallange.orders.core.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String orderId) {
        super("Order not found for id #".concat(orderId));
    }
}

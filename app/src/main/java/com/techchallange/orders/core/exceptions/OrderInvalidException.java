package com.techchallange.orders.core.exceptions;

public class OrderInvalidException extends RuntimeException {
    public OrderInvalidException(String message) {
        super(message);
    }
}

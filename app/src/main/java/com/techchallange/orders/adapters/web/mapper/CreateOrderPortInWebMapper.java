package com.techchallange.orders.adapters.web.mapper;

import com.techchallange.orders.core.domains.Order;

import java.net.URI;

public class CreateOrderPortInWebMapper {
    public static Object toDto(Order order) {
        return order;
    }
}

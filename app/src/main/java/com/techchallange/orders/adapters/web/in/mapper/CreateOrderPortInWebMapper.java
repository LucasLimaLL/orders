package com.techchallange.orders.adapters.web.in.mapper;

import com.techchallange.orders.core.domains.order.Order;

public class CreateOrderPortInWebMapper {
    public static Object toDto(Order order) {
        return order;
    }
}

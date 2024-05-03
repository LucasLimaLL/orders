package com.techchallange.orders.adapters.web.mapper;

import com.techchallange.orders.core.domains.order.Order;

public class CreateOrderPortInWebMapper {
    public static Object toDto(Order order) {
        return order;
    }
}

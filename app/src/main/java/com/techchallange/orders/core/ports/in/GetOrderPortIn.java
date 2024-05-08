package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Order;

import java.util.Optional;

public interface GetOrderPortIn {

    Optional<Order> get(String orderId);
}

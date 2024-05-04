package com.techchallange.orders.core.ports.out;

import com.techchallange.orders.core.domains.order.Order;

import java.util.Optional;

public interface GetOrderByIdPortOut {

    Optional<Order> get(String orderId);
}

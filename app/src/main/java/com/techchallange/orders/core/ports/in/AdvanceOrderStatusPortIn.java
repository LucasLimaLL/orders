package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Order;

public interface AdvanceOrderStatusPortIn {

    Order advance(Order order);
}

package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.Order;

public interface AdvanceOrderStatusPortIn {

    Order advance(Order order);
}

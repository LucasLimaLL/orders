package com.techchallange.orders.core.ports.out;

import com.techchallange.orders.core.domains.order.Order;

public interface SaveOrderPortOut {

    Order save(Order order);
}

package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;

public interface UpdateOrderPortIn {

    Order update(Order order, Combo combo);

    Order update(String orderId, Combo combo);
}

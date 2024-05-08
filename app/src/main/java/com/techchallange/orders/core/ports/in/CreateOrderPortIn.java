package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.user.User;

public interface CreateOrderPortIn {

    Order create(Combo combo, User user);

}

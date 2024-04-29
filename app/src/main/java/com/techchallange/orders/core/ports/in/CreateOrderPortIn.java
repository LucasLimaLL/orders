package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.Combo;
import com.techchallange.orders.core.domains.Order;
import com.techchallange.orders.core.domains.User;

import java.util.List;

public interface CreateOrderPortIn {

    Order create(List<Combo> combos, User user);

}

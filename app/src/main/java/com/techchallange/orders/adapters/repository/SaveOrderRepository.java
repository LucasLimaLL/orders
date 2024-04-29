package com.techchallange.orders.adapters.repository;

import com.techchallange.orders.core.domains.Order;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;

public class SaveOrderRepository implements SaveOrderPortOut {
    @Override
    public Order save(Order order) {
        return order;
    }
}

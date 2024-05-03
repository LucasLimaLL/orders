package com.techchallange.orders.adapters.repository;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderRepository implements SaveOrderPortOut {
    @Override
    public Order save(Order order) {
        return order;
    }
}

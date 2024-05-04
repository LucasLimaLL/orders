package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderPersistence implements SaveOrderPortOut {
    @Override
    public Order save(Order order) {
        return order;
    }
}

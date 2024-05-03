package com.techchallange.orders.adapters.repository;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;

public class GetOrderByIdRepository implements GetOrderByIdPortOut {

    @Override
    public Order get(String orderId) {
        return null;
    }
}

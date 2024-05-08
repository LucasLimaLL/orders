package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.in.GetOrderPortIn;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;

import java.util.Optional;

public class GetOrderUseCase implements GetOrderPortIn {

    private final GetOrderByIdPortOut getOrderByIdPortOut;

    public GetOrderUseCase(GetOrderByIdPortOut getOrderByIdPortOut) {
        this.getOrderByIdPortOut = getOrderByIdPortOut;
    }

    @Override
    public Optional<Order> get(String orderId) {
        return getOrderByIdPortOut.get(orderId);
    }
}

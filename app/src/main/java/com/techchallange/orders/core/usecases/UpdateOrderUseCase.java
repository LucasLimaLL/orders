package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.exceptions.OrderNotFoundException;
import com.techchallange.orders.core.ports.in.UpdateOrderPortIn;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;

public class UpdateOrderUseCase implements UpdateOrderPortIn {

    private final GetOrderByIdPortOut getOrderByIdPortOut;
    private final SaveOrderPortOut saveOrderPortOut;

    public UpdateOrderUseCase(GetOrderByIdPortOut getOrderByIdPortOut, SaveOrderPortOut saveOrderPortOut) {
        this.getOrderByIdPortOut = getOrderByIdPortOut;
        this.saveOrderPortOut = saveOrderPortOut;
    }

    @Override
    public Order update(Order order, Combo combo) {

        return saveOrderPortOut.save(order
                .toBuilder()
                .withCombo(combo)
                .build());
    }

    @Override
    public Order update(String orderId, Combo combo) {

        var order = getOrderByIdPortOut.get(orderId);

        if (order.isEmpty()) {
            throw new OrderNotFoundException(orderId);
        }

        return update(order.get(), combo);
    }
}

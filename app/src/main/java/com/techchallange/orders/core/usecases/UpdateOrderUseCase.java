package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.in.UpdateOrderPortIn;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateOrderUseCase implements UpdateOrderPortIn {

    private GetOrderByIdPortOut getOrderByIdPortOut;
    private SaveOrderPortOut saveOrderPortOut;

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
        return update(order, combo);
    }
}

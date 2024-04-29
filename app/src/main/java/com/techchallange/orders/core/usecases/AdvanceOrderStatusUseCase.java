package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.Order;
import com.techchallange.orders.core.ports.in.AdvanceOrderStatusPortIn;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdvanceOrderStatusUseCase implements AdvanceOrderStatusPortIn {

    final SaveOrderPortOut saveOrderPortOut;

    @Override
    public Order advance(Order order) {
        order
                .toBuilder()
                .status(order.getStatus().advance())
                .build();

        return saveOrderPortOut.save(order);
    }
}

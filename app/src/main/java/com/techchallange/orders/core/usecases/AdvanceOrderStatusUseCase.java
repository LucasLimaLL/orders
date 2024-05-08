package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.in.AdvanceOrderStatusPortIn;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import lombok.RequiredArgsConstructor;

public class AdvanceOrderStatusUseCase implements AdvanceOrderStatusPortIn {

    private final SaveOrderPortOut saveOrderPortOut;

    public AdvanceOrderStatusUseCase(SaveOrderPortOut saveOrderPortOut) {
        this.saveOrderPortOut = saveOrderPortOut;
    }

    @Override
    public Order advance(Order order) {
        order
                .toBuilder()
                .withStatus(order.getStatus().advance())
                .build();

        return saveOrderPortOut.save(order);
    }
}

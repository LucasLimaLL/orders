package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.in.UpdateOrderPortIn;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;

import java.math.BigDecimal;

public class UpdateOrderUseCase implements UpdateOrderPortIn {

    private final SaveOrderPortOut saveOrderPortOut;

    public UpdateOrderUseCase(SaveOrderPortOut saveOrderPortOut) {
        this.saveOrderPortOut = saveOrderPortOut;
    }

    @Override
    public Order update(Order order, Combo combo) {

        return saveOrderPortOut.save(order
                .toBuilder()
                .withCombo(combo)
                .withAmount(combo == null
                        ? BigDecimal.ZERO
                        : combo.calculate())
                .build());
    }

}

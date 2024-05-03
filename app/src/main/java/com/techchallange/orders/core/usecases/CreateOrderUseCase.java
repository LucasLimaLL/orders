package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.order.Status;
import com.techchallange.orders.core.domains.user.User;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CreateOrderUseCase implements CreateOrderPortIn {

    private final GenerateIdPortOut generateIdPortOut;

    @Override
    public Order create(Combo combo, User user) {

        var createdOrder = Order
                .builder()
                .withCombo(combo)
                .withRequester(user)
                .withAmount(calculateFinalPrice(combo))
                .withStatus(Status.CREATED)
                .build();

        return createdOrder
                .toBuilder()
                .withId(generateIdPortOut.generateId(createdOrder))
                .build();
    }

    private BigDecimal calculateFinalPrice(Combo combo) {
        return combo == null
                ? BigDecimal.ZERO
                : combo.calculate();
    }
}

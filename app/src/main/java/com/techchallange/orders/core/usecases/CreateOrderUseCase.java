package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.order.Status;
import com.techchallange.orders.core.domains.user.User;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateOrderUseCase implements CreateOrderPortIn {

    private final GenerateIdPortOut generateIdPortOut;

    public CreateOrderUseCase(GenerateIdPortOut generateIdPortOut) {
        this.generateIdPortOut = generateIdPortOut;
    }

    @Override
    public Order create(Combo combo, User user) {

        var createdOrder = Order
                .builder()
                .withCombo(combo)
                .withRequester(user)
                .withAmount(combo == null
                        ? BigDecimal.ZERO
                        : combo.calculate())
                .withRequestedAt(LocalDateTime.now())
                .withStatus(Status.CREATED)
                .build();

        return createdOrder
                .toBuilder()
                .withId(generateIdPortOut.generateId(createdOrder))
                .build();
    }
}

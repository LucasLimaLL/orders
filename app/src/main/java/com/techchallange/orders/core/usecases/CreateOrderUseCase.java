package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.Combo;
import com.techchallange.orders.core.domains.Item;
import com.techchallange.orders.core.domains.Order;
import com.techchallange.orders.core.domains.Status;
import com.techchallange.orders.core.domains.User;
import com.techchallange.orders.core.exceptions.OrderInvalidException;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class CreateOrderUseCase implements CreateOrderPortIn {

    final SaveOrderPortOut saveOrderPortOut;

    @Override
    public Order create(List<Combo> combos, User user) {

        if (combos == null || combos.isEmpty()) {
            throw new OrderInvalidException("No combos found");
        }

        var createdOrder = Order
                .builder()
                .withCombos(combos)
                .withRequester(user)
                .withAmount(calculateFinalPrice(combos))
                .withStatus(Status.CREATED)
                .build();

        return saveOrderPortOut.save(createdOrder);
    }

    private BigDecimal calculateFinalPrice(List<Combo> combos) {

        return combos.
                stream()
                .map(Combo::calculate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.adapters.persistence.mappers.OrderMapper;
import com.techchallange.orders.adapters.persistence.repositories.OrderRepository;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetOrderByIdPersistence implements GetOrderByIdPortOut {

    private final OrderRepository orderRepository;

    public GetOrderByIdPersistence(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> get(String orderId) {
        final var entity = orderRepository.findById(Long.valueOf(orderId));

        return entity.map(OrderMapper::toDomain);

    }
}

package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.adapters.persistence.mapper.OrderMapper;
import com.techchallange.orders.adapters.persistence.repositories.OrderRepository;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateIdPersistence implements GenerateIdPortOut {

    private final OrderRepository orderRepository;

    public GenerateIdPersistence(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String generateId(Order createdOrder) {
        final var entity = this.orderRepository.save(OrderMapper.toEntity(createdOrder));
        return String.valueOf(entity.getId());
    }
}

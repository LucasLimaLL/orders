package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.adapters.persistence.entities.ItemEntity;
import com.techchallange.orders.adapters.persistence.entities.OrderItemEntity;
import com.techchallange.orders.adapters.persistence.mappers.ItemMapper;
import com.techchallange.orders.adapters.persistence.mappers.OrderMapper;
import com.techchallange.orders.adapters.persistence.mappers.UserMapper;
import com.techchallange.orders.adapters.persistence.repositories.OrderRepository;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateIdPersistence implements GenerateIdPortOut {

    private final OrderRepository orderRepository;

    public GenerateIdPersistence(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long generateId(Order createdOrder) {
        var entity = OrderMapper.toEntity(createdOrder);
        var order = this.orderRepository.save(entity);

        entity = order
                .toBuilder()
                .withItens(
                        createdOrder
                                .getCombo()
                                .getItems()
                                .stream()
                                .map(item -> OrderItemEntity
                                        .builder()
                                        .withQuantity(item.getQuantity())
                                        .withOrder(order)
                                        .withItem(ItemMapper.toEntity(item))
                                        .build())
                                .toList()
                )
                .build();

        this.orderRepository.save(entity);

        return entity.getId();
    }
}

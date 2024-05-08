package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.adapters.persistence.entities.OrderItemEntity;
import com.techchallange.orders.adapters.persistence.mappers.ItemMapper;
import com.techchallange.orders.adapters.persistence.mappers.OrderMapper;
import com.techchallange.orders.adapters.persistence.repositories.OrderRepository;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderPersistence implements SaveOrderPortOut {
    private final OrderRepository orderRepository;

    public SaveOrderPersistence(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order updatedOrder) {
        var entity = OrderMapper.toEntity(updatedOrder);

        var order = entity
                .toBuilder()
                .withItens(
                        updatedOrder
                                .getCombo()
                                .getItems()
                                .stream()
                                .map(item -> OrderItemEntity
                                        .builder()
                                        .withQuantity(item.getQuantity())
                                        .withOrder(entity)
                                        .withItem(ItemMapper.toEntity(item))
                                        .build())
                                .toList()
                )
                .build();

        this.orderRepository.save(order);
        return OrderMapper.toDomain(order);
    }
}

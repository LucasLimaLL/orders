package com.techchallange.orders.adapters.persistence.mapper;

import com.techchallange.orders.adapters.persistence.entities.OrderEntity;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.order.Status;

public class OrderMapper {

    public static OrderEntity toEntity(Order createdOrder) {
        return OrderEntity
                .builder()
                .withId(createdOrder.getId() == null ? null : Long.valueOf(createdOrder.getId()))
                .withStatus(createdOrder.getStatus().name())
                .withAmount(createdOrder.getAmount())
                .withRequestedAt(createdOrder.getRequestedAt())
                .build();

    }

    public static Order toDomain(OrderEntity orderEntity) {
        return Order
                .builder()
                .withId(String.valueOf(orderEntity.getId()))
                .withStatus(Status.valueOf(orderEntity.getStatus()))
                .withAmount(orderEntity.getAmount())
                .withRequestedAt(orderEntity.getRequestedAt())
                .build();
    }
}

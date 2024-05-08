package com.techchallange.orders.adapters.persistence.mappers;

import com.techchallange.orders.adapters.persistence.entities.OrderEntity;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.order.Status;
import com.techchallange.orders.core.domains.payment.Payment;

import java.util.Objects;

public class OrderMapper {
    public static OrderEntity toEntity(Order order) {
        return OrderEntity
                .builder()
                .withId(order.getId())
                .withRequestedAt(order.getRequestedAt())
                .withStatus(order.getStatus().name())
                .withAmount(order.getAmount())
                .withPaymentMethod(
                        Objects.isNull(order.getPayment())
                                ? null
                                : PaymentMethodMapper.toEntity(order.getPayment()))
                .withRequester(UserMapper.toEntity(order.getRequester()))
                .build();
    }

    public static Order toDomain(OrderEntity order) {
        return Order
                .builder()
                .withId(order.getId())
                .withRequestedAt(order.getRequestedAt())
                .withStatus(Status.valueOf(order.getStatus()))
                .withAmount(order.getAmount())
                .withPayment(
                        Objects.isNull(order.getPaymentMethod())
                                ? null
                                : PaymentMethodMapper.toDomain(order.getPaymentMethod()))
                .withRequester(UserMapper.toDomain(order.getRequester()))
                .withCombo(ItemMapper.toDomain(order.getItens()))
                .build();
    }
}

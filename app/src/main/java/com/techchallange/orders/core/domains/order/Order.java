package com.techchallange.orders.core.domains.order;

import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.user.User;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Builder(setterPrefix = "with", toBuilder = true)
public class Order {

    private Long id;
    private User requester;
    private Combo combo;
    private ZonedDateTime requestedAt;
    private BigDecimal amount;
    private Status status;
    private Payment payment;
}

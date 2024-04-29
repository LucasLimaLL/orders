package com.techchallange.orders.core.domains;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder(toBuilder = true)
public class Order {

    private String id;
    private User requester;
    private List<Combo> combos;
    private BigDecimal amount;
    private Status status;
}

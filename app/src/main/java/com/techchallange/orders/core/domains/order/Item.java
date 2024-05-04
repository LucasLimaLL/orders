package com.techchallange.orders.core.domains.order;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(setterPrefix = "with", toBuilder = true)
public class Item {

    private Long id;
    private String name;
    private ItemType type;
    private BigDecimal price;
    private Float quantity;

}

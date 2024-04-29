package com.techchallange.orders.core.domains;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Item {

    private String name;
    private ItemType type;
    private BigDecimal price;
    private Float quantity;

}

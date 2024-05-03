package com.techchallange.orders.support;

import com.techchallange.orders.core.domains.order.Item;
import com.techchallange.orders.core.domains.order.ItemType;

import java.math.BigDecimal;

public class ItemSupport {

    private ItemSupport() {}

    public static Item getSnack() {
        return Item
                .builder()
                .withType(ItemType.SNACK)
                .withName("Hamburguer")
                .withPrice(BigDecimal.valueOf(9.9))
                .withQuantity(1F)
                .build();
    }
    public static Item getAccompaniment() {
        return Item
                .builder()
                .withType(ItemType.ACCOMPANIMENT)
                .withName("Fritas")
                .withPrice(BigDecimal.valueOf(2.9))
                .withQuantity(1F)
                .build();
    }
    public static Item getBeverage() {
        return Item
                .builder()
                .withType(ItemType.BEVERAGE)
                .withName("Coca Cola Lata")
                .withPrice(BigDecimal.valueOf(4.9))
                .withQuantity(1F)
                .build();
    }
    public static Item getDessert() {
        return Item
                .builder()
                .withType(ItemType.DESSERT)
                .withName("Pudim")
                .withPrice(BigDecimal.valueOf(3.9))
                .withQuantity(1F)
                .build();
    }

}

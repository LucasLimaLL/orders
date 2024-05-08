package com.techchallange.orders.adapters.persistence.mappers;

import com.techchallange.orders.adapters.persistence.entities.ItemEntity;
import com.techchallange.orders.adapters.persistence.entities.OrderItemEntity;
import com.techchallange.orders.core.domains.order.Combo;
import com.techchallange.orders.core.domains.order.Item;
import com.techchallange.orders.core.domains.order.ItemType;
import com.techchallange.orders.core.domains.order.Order;

import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    public static Combo toDomain(List<OrderItemEntity> itens) {
        var itemList = itens == null || itens.isEmpty()
                ? new ArrayList<Item>()
                : itens
                .stream()
                .map(item -> Item
                        .builder()
                        .withId(item.getItem().getId())
                        .withName(item.getItem().getName())
                        .withPrice(item.getItem().getPrice())
                        .withType(ItemType.valueOf(item.getItem().getType()))
                        .withQuantity(item.getQuantity())
                        .build())
                .toList();

        return Combo
                .builder()
                .withItems(itemList)
                .build();
    }

    public static List<OrderItemEntity> toEntity(Combo combo) {
        return combo.getItems() == null || combo.getItems().isEmpty()
                ? List.of()
                : combo.getItems()
                .stream()
                .map(item -> OrderItemEntity
                        .builder()
                        .withItem(
                                ItemEntity
                                        .builder()
                                        .withId(item.getId())
                                        .withName(item.getName())
                                        .withPrice(item.getPrice())
                                        .withType(item.getType().name())
                                        .build())
                        .withQuantity(item.getQuantity())
                        .build()
                )
                .toList();
    }

    public static Item toDomain(ItemEntity item) {
        return Item
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withType(ItemType.valueOf(item.getType()))
                .withPrice(item.getPrice())
                .build();
    }

    public static ItemEntity toEntity(Item item) {
        return ItemEntity
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withPrice(item.getPrice())
                .withType(item.getType().name())
                .build();
    }
}

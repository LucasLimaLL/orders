package com.techchallange.orders.adapters.web.in.mapper;

import com.techchallange.orders.adapters.web.in.dto.ItemDto;
import com.techchallange.orders.core.domains.order.Item;
import com.techchallange.orders.core.domains.order.ItemType;

import java.util.List;

public class CreateOrderPortInItemWebMapper {

    public static List<Item> toDomain(List<ItemDto> items) {
        return items == null || items.isEmpty()
                ? List.of()
                : items
                .stream()
                .map(item ->
                        Item
                                .builder()
                                .withId(item.getId())
                                .withName(item.getName())
                                .withType(ItemType.valueOf(item.getType()))
                                .withPrice(item.getPrice())
                                .withQuantity(item.getQuantity())
                                .build())
                .toList();
    }
}

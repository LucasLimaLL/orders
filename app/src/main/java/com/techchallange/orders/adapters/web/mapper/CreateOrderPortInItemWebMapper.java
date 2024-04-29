package com.techchallange.orders.adapters.web.mapper;

import com.techchallange.orders.adapters.web.dto.ComboDto;
import com.techchallange.orders.adapters.web.dto.ItemDto;
import com.techchallange.orders.core.domains.Combo;
import com.techchallange.orders.core.domains.Item;
import com.techchallange.orders.core.domains.ItemType;

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
                                .withName(item.getName())
                                .withType(ItemType.valueOf(item.getType()))
                                .withPrice(item.getPrice())
                                .withQuantity(item.getQuantity())
                                .build())
                .toList();
    }
}

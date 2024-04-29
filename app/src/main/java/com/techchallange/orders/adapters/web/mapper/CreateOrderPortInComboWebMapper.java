package com.techchallange.orders.adapters.web.mapper;

import com.techchallange.orders.adapters.web.dto.ComboDto;
import com.techchallange.orders.core.domains.Combo;

import java.util.List;

public class CreateOrderPortInComboWebMapper {

    public static List<Combo> toDomain(List<ComboDto> combos) {
        return combos == null || combos.isEmpty()
                ? List.of()
                : combos
                .stream()
                .map(combo ->
                        Combo
                                .builder()
                                .withItems(CreateOrderPortInItemWebMapper.toDomain(combo.getItems()))
                                .build())
                .toList();
    }
}

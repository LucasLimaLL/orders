package com.techchallange.orders.adapters.web.in.mapper;

import com.techchallange.orders.adapters.web.in.dto.ComboDto;
import com.techchallange.orders.core.domains.order.Combo;

import static java.util.Objects.isNull;

public class CreateOrderPortInComboWebMapper {

    public static Combo toDomain(ComboDto combo) {
        return isNull(combo)
                ? null
                : Combo
                .builder()
                .withItems(CreateOrderPortInItemWebMapper.toDomain(combo.getItems()))
                .build();
    }
}

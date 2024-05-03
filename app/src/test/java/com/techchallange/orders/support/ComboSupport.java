package com.techchallange.orders.support;

import com.techchallange.orders.core.domains.order.Combo;

import java.util.List;

public class ComboSupport {

    private ComboSupport() {}

    public static Combo getCombo() {
        return Combo
                .builder()
                .withItems(
                        List.of(
                                ItemSupport.getSnack(),
                                ItemSupport.getBeverage(),
                                ItemSupport.getAccompaniment(),
                                ItemSupport.getDessert()
                        )
                )
                .build();
    }

}

package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.in.SearchOrdersPortIn;
import com.techchallange.orders.core.ports.out.SearchOrdersPortOut;

import java.util.List;
import java.util.Map;

public class SearchOrdersUseCase implements SearchOrdersPortIn {

    private final SearchOrdersPortOut searchOrdersPortOut;

    public SearchOrdersUseCase(SearchOrdersPortOut searchOrdersPortOut) {
        this.searchOrdersPortOut = searchOrdersPortOut;
    }

    @Override
    public List<Order> search(Map<String, Object> params) {
        return searchOrdersPortOut.search(params);
    }
}

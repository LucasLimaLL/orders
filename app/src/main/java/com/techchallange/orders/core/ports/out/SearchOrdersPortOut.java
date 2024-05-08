package com.techchallange.orders.core.ports.out;

import com.techchallange.orders.core.domains.order.Order;

import java.util.List;
import java.util.Map;

public interface SearchOrdersPortOut {

    List<Order> search(Map<String, Object> params);
}

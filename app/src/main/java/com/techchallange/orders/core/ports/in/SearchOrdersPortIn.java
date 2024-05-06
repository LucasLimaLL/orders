package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SearchOrdersPortIn {

    List<Order> search(Map<String, Object> params);
}

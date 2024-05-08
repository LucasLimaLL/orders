package com.techchallange.orders.adapters.persistence;

import com.techchallange.orders.adapters.persistence.mappers.OrderMapper;
import com.techchallange.orders.adapters.persistence.repositories.OrderRepository;
import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.ports.out.SearchOrdersPortOut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SearchOrdersPersistence implements SearchOrdersPortOut {

    private final OrderRepository orderRepository;

    public SearchOrdersPersistence(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> search(Map<String, Object> params) {
        var orders = orderRepository.findAll();
        return orders
                .stream()
                .map(OrderMapper::toDomain)
                .toList();
    }
}

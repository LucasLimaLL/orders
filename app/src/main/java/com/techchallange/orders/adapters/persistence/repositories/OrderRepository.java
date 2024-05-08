package com.techchallange.orders.adapters.persistence.repositories;

import com.techchallange.orders.adapters.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}

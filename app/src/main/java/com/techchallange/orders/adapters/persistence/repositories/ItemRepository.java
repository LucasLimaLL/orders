package com.techchallange.orders.adapters.persistence.repositories;

import com.techchallange.orders.adapters.persistence.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}

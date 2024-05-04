package com.techchallange.orders.adapters.persistence.repositories;

import com.techchallange.orders.adapters.persistence.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}

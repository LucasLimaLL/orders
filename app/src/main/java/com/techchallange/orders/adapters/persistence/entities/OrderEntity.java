package com.techchallange.orders.adapters.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Builder(setterPrefix = "with")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime requestedAt;

    private String status;

    @Column(name = "payment_method")
    private String payment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "requester")
    private UserEntity requester;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemEntity> itens;
}

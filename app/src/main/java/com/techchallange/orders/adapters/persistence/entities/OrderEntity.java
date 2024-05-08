package com.techchallange.orders.adapters.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Builder(setterPrefix = "with", toBuilder = true)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL })
    @JoinColumn(name = "requester_document", referencedColumnName = "cpf", unique = true)
    private UserEntity requester;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> itens;

    private ZonedDateTime requestedAt;
    private BigDecimal amount;
    private String status;
    private String paymentMethod;
}

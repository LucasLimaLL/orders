package com.techchallange.orders.adapters.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "clients")
@Builder(setterPrefix = "with")
public class UserEntity {

    @Id
    private String cpf;
    private String name;
    private String email;
}

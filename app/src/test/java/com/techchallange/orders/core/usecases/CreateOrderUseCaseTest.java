package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import com.techchallange.orders.support.ComboSupport;
import com.techchallange.orders.support.UserSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateOrderUseCaseTest {

    @Mock
    private GenerateIdPortOut generateIdPortOut;

    private CreateOrderUseCase createOrderUseCase;


    @BeforeEach
    void setUp() {
        this.createOrderUseCase = new CreateOrderUseCase(generateIdPortOut);
    }

    @Test
    @DisplayName("Scenario with List of combo and user filled")
    void testScenarioWithListOfComboAndUserFilled() {

        final var key = UUID.randomUUID().toString();
        final var user = UserSupport.getUser();
        final var combo = ComboSupport.getCombo();

        when(generateIdPortOut.generateId(Mockito.any())).thenReturn(key);

        final var order = this.createOrderUseCase.create(combo, user);

        assertAll(
                () -> assertThat(order).isNotNull(),
                () -> assertThat(order.getId()).isEqualTo(key),
                () -> assertThat(order.getCombo()).isNotNull(),
                () -> assertThat(order.getAmount()).isEqualTo(new BigDecimal("21.60")),
                () -> assertThat(order.getRequester()).isNotNull(),
                () -> assertThat(order.getRequester().getName()).isEqualTo(user.getName()),
                () -> assertThat(order.getRequester().getCpf().getNumber()).isEqualTo(user.getCpf().getNumber()),
                () -> assertThat(order.getRequester().getEmail().getEmail()).isEqualTo(user.getEmail().getEmail())
        );
    }

    @Test
    @DisplayName("Scenario with list of combo filled")
    void testScenarioWithListOfComboFilled() {

        final var key = UUID.randomUUID().toString();
        final var combo = ComboSupport.getCombo();

        when(generateIdPortOut.generateId(Mockito.any())).thenReturn(key);

        final var order = this.createOrderUseCase.create(combo, null);

        assertAll(
                () -> assertThat(order).isNotNull(),
                () -> assertThat(order.getId()).isEqualTo(key),
                () -> assertThat(order.getCombo()).isNotNull(),
                () -> assertThat(order.getAmount()).isEqualTo(new BigDecimal("21.60")),
                () -> assertThat(order.getRequester()).isNull()
        );
    }

    @Test
    @DisplayName("Scenario with user filled")
    void testScenarioWithUserFilled() {

        final var key = UUID.randomUUID().toString();
        final var user = UserSupport.getUser();

        when(generateIdPortOut.generateId(Mockito.any())).thenReturn(key);

        final var order = this.createOrderUseCase.create(null, user);

        assertAll(
                () -> assertThat(order).isNotNull(),
                () -> assertThat(order.getId()).isEqualTo(key),
                () -> assertThat(order.getCombo()).isNull(),
                () -> assertThat(order.getRequester()).isNotNull(),
                () -> assertThat(order.getRequester().getName()).isEqualTo(user.getName()),
                () -> assertThat(order.getRequester().getCpf().getNumber()).isEqualTo(user.getCpf().getNumber()),
                () -> assertThat(order.getRequester().getEmail().getEmail()).isEqualTo(user.getEmail().getEmail())
        );
    }

    @Test
    @DisplayName("Scenario with nothing filled")
    void testScenarioWithNothingFilled() {

        final var key = UUID.randomUUID().toString();

        when(generateIdPortOut.generateId(Mockito.any())).thenReturn(key);

        final var order = this.createOrderUseCase.create(null, null);

        assertAll(
                () -> assertThat(order).isNotNull(),
                () -> assertThat(order.getId()).isEqualTo(key),
                () -> assertThat(order.getCombo()).isNull(),
                () -> assertThat(order.getRequester()).isNull()
        );
    }
}
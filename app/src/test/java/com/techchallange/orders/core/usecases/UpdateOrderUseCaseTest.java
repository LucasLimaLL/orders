package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateOrderUseCaseTest {
    
    @Mock
    private SaveOrderPortOut saveOrderPortOut;

    private UpdateOrderUseCase updateOrderUseCase;

    @BeforeEach
    void setUp() {
        this.updateOrderUseCase = new UpdateOrderUseCase(saveOrderPortOut);
    }


}
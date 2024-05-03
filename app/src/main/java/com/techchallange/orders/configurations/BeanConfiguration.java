package com.techchallange.orders.configurations;

import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import com.techchallange.orders.core.usecases.AdvanceOrderStatusUseCase;
import com.techchallange.orders.core.usecases.CreateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreateOrderUseCase beanCreateOrderUseCase(GenerateIdPortOut generateIdPortOut) {
        return new CreateOrderUseCase(generateIdPortOut);
    }

    @Bean
    AdvanceOrderStatusUseCase beanAdvanceOrderStatusUseCase(SaveOrderPortOut saveOrderPortOut) {
        return new AdvanceOrderStatusUseCase(saveOrderPortOut);
    }

}

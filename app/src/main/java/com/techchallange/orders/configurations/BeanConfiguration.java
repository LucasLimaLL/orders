package com.techchallange.orders.configurations;

import com.techchallange.orders.core.ports.out.GenerateIdPortOut;
import com.techchallange.orders.core.ports.out.GetOrderByIdPortOut;
import com.techchallange.orders.core.ports.out.PaymentGatewayPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import com.techchallange.orders.core.usecases.AdvanceOrderStatusUseCase;
import com.techchallange.orders.core.usecases.ConfirmOrderUseCase;
import com.techchallange.orders.core.usecases.CreateOrderUseCase;
import com.techchallange.orders.core.usecases.PayOrderUseCase;
import com.techchallange.orders.core.usecases.UpdateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

    @Bean
    ConfirmOrderUseCase beanConfirmOrderUseCase(SaveOrderPortOut saveOrderPortOut, List<PaymentGatewayPortOut> paymentGatewaysPortOut) {
        return new ConfirmOrderUseCase(saveOrderPortOut, paymentGatewaysPortOut);
    }

    @Bean
    PayOrderUseCase beanPayOrderUseCase(List<PaymentGatewayPortOut> paymentGatewaysPortOut) {
        return new PayOrderUseCase(paymentGatewaysPortOut);
    }

    @Bean
    UpdateOrderUseCase beanUpdateOrderUseCase(GetOrderByIdPortOut getOrderByIdPortOut, SaveOrderPortOut saveOrderPortOut) {
        return new UpdateOrderUseCase(getOrderByIdPortOut, saveOrderPortOut);
    }




}

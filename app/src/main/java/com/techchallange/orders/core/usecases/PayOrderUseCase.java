package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.exceptions.PaymentMethodNotValidatedException;
import com.techchallange.orders.core.ports.in.PayOrderPortIn;
import com.techchallange.orders.core.ports.out.PaymentGatewayPortOut;

import java.util.List;

public class PayOrderUseCase implements PayOrderPortIn {

    private final List<PaymentGatewayPortOut> paymentGatewaysPortOut;

    public PayOrderUseCase(List<PaymentGatewayPortOut> paymentGatewaysPortOut) {
        this.paymentGatewaysPortOut = paymentGatewaysPortOut;
    }

    @Override
    public Order pay(Order order) {

        final var gateway = this.paymentGatewaysPortOut
                .stream()
                .filter(paymentGateway -> paymentGateway.selected(order.getPayment().getPaymentType()))
                .findFirst();

        if (gateway.isEmpty()) {
            throw new PaymentMethodNotValidatedException(order.getPayment().getPaymentType());
        }

        gateway
                .get()
                .pay(order.getPayment(), order.getAmount());

        return order;
    }
}

package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.payment.PaymentType;
import com.techchallange.orders.core.exceptions.PaymentMethodNotValidatedException;
import com.techchallange.orders.core.ports.in.ConfirmOrderPortIn;
import com.techchallange.orders.core.ports.out.PaymentGatewayPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ConfirmOrderUseCase implements ConfirmOrderPortIn {

    private SaveOrderPortOut saveOrderPortOut;

    private List<PaymentGatewayPortOut> paymentGatewaysPortOut;

    @Override
    public Order confirm(Order order, PaymentType paymentType) {

        var gatewaySelected = paymentGatewaysPortOut
                .stream()
                .filter(gateway -> gateway.selected(paymentType))
                .findFirst();

        if (gatewaySelected.isEmpty()) {
            throw new PaymentMethodNotValidatedException(paymentType);
        }

        return saveOrderPortOut.save(order
                .toBuilder()
                .withPayment(gatewaySelected.get().collectPaymentDetails())
                .build());
    }
}

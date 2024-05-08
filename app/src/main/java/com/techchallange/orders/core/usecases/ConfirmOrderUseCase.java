package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.payment.PaymentType;
import com.techchallange.orders.core.exceptions.PaymentMethodNotValidatedException;
import com.techchallange.orders.core.ports.in.ConfirmOrderPortIn;
import com.techchallange.orders.core.ports.out.PaymentGatewayPortOut;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;

import java.util.List;

public class ConfirmOrderUseCase implements ConfirmOrderPortIn {

    private final SaveOrderPortOut saveOrderPortOut;

    private final List<PaymentGatewayPortOut> paymentGatewaysPortOut;

    public ConfirmOrderUseCase(SaveOrderPortOut saveOrderPortOut, List<PaymentGatewayPortOut> paymentGatewaysPortOut) {
        this.saveOrderPortOut = saveOrderPortOut;
        this.paymentGatewaysPortOut = paymentGatewaysPortOut;
    }

    @Override
    public Order confirm(Order order, PaymentType paymentType) {

        var gatewaySelected = paymentGatewaysPortOut
                .stream()
                .filter(gateway -> gateway.selected(paymentType))
                .findFirst();

        var status = order.getStatus();

        if (gatewaySelected.isEmpty()) {
            throw new PaymentMethodNotValidatedException(paymentType);
        }

        return saveOrderPortOut.save(order
                .toBuilder()
                .withPayment(gatewaySelected.get().collectPaymentDetails())
                .withStatus(status.advance())
                .build());
    }
}

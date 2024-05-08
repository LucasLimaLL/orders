package com.techchallange.orders.core.usecases;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.order.Status;
import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.payment.PaymentType;
import com.techchallange.orders.core.domains.payment.QrCodePayment;
import com.techchallange.orders.core.ports.in.ConfirmOrderPortIn;
import com.techchallange.orders.core.ports.out.SaveOrderPortOut;

public class ConfirmOrderUseCase implements ConfirmOrderPortIn {

    private final SaveOrderPortOut saveOrderPortOut;


    public ConfirmOrderUseCase(SaveOrderPortOut saveOrderPortOut) {
        this.saveOrderPortOut = saveOrderPortOut;
    }

    @Override
    public Order confirm(Order order, PaymentType paymentType) {

        Payment payment = null;
        if (paymentType == PaymentType.QR_CODE) {
            payment = QrCodePayment
                    .builder()
                    .build();
        }

        return saveOrderPortOut.save(order
                .toBuilder()
                .withStatus(Status.AWAITING_PAYMENT)
                .withPayment(payment)
                .build());
    }
}

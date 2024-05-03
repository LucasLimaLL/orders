package com.techchallange.orders.core.ports.out;

import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.payment.PaymentType;

import java.math.BigDecimal;

public interface PaymentGatewayPortOut {

    boolean pay(BigDecimal amount);

    boolean selected(PaymentType paymentType);

    Payment collectPaymentDetails();
}

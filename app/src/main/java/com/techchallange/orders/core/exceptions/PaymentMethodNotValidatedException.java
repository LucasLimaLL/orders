package com.techchallange.orders.core.exceptions;

import com.techchallange.orders.core.domains.payment.PaymentType;

public class PaymentMethodNotValidatedException extends RuntimeException {
    public PaymentMethodNotValidatedException() {
        super("Payment not valid");
    }

    public PaymentMethodNotValidatedException(PaymentType paymentType) {
        super("Payment not validated for " + paymentType.name());
    }
}

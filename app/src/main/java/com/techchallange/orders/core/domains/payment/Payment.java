package com.techchallange.orders.core.domains.payment;

import lombok.Getter;

public abstract class Payment {

    private final PaymentType paymentType;

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}

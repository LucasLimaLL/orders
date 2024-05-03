package com.techchallange.orders.core.domains.payment;

public abstract class Payment {

    private final PaymentType paymentType;

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public abstract void additionalInfo(Object... objects);
}

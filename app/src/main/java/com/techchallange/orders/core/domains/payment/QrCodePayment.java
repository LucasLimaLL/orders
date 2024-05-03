package com.techchallange.orders.core.domains.payment;

public class QrCodePayment extends Payment {

    public QrCodePayment() {
        super(PaymentType.QR_CODE);
    }

    @Override
    public void additionalInfo(Object... objects) {

    }
}

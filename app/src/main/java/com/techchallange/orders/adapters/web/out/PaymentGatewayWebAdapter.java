package com.techchallange.orders.adapters.web.out;

import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.payment.PaymentType;
import com.techchallange.orders.core.domains.payment.QrCodePayment;
import com.techchallange.orders.core.ports.out.PaymentGatewayPortOut;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentGatewayWebAdapter implements PaymentGatewayPortOut {

    @Override
    public boolean pay(Payment payment, BigDecimal amount) {
        return false;
    }

    @Override
    public boolean selected(PaymentType paymentType) {
        return paymentType == PaymentType.QR_CODE;
    }

    @Override
    public Payment collectPaymentDetails() {
        return new QrCodePayment("", "", "");
    }
}

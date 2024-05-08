package com.techchallange.orders.adapters.persistence.mappers;

import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.payment.QrCodePayment;
import com.techchallange.orders.core.exceptions.PaymentMethodNotValidatedException;

public class PaymentMethodMapper {
    public static Payment toDomain(String paymentMethod) {
        switch (paymentMethod) {
            case "QR_CODE":
                return QrCodePayment
                        .builder()
                        .build();
            default:
                throw new PaymentMethodNotValidatedException();
        }

    }

    public static String toEntity(Payment payment) {
        return payment.getPaymentType().name();
    }
}

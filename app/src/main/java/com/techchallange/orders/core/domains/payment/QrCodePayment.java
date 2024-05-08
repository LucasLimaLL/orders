package com.techchallange.orders.core.domains.payment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class QrCodePayment extends Payment {

    private final String userId;
    private final String externalId;
    private final String sponsorId;

    public QrCodePayment(String userId,
                         String externalId,
                         String sponsorId) {
        super(PaymentType.QR_CODE);
        this.userId = userId;
        this.externalId = externalId;
        this.sponsorId = sponsorId;
    }

}

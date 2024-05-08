package com.techchallange.orders.core.ports.in;

import com.techchallange.orders.core.domains.order.Order;
import com.techchallange.orders.core.domains.payment.PaymentType;

public interface ConfirmOrderPortIn {

    Order confirm(Order order, PaymentType paymentType);
}

package com.techchallange.orders.adapters.web.in;

import com.techchallange.orders.adapters.web.in.dto.PaymentOrderDto;
import com.techchallange.orders.adapters.web.in.dto.RequestOrderDto;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInComboWebMapper;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInUserWebMapper;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInWebMapper;
import com.techchallange.orders.core.domains.payment.Payment;
import com.techchallange.orders.core.domains.payment.PaymentType;
import com.techchallange.orders.core.ports.in.ConfirmOrderPortIn;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import com.techchallange.orders.core.ports.in.GetOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class ConfirmOrderRestController {

    private final ConfirmOrderPortIn confirmOrderPortIn;
    private final GetOrderPortIn getOrderPortIn;

    @PostMapping(path = "/api/v1/orders/{id}/payment")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @PathVariable("id") String id,
                                    @RequestBody PaymentOrderDto body) {


        var order = getOrderPortIn.get(id);

        return order.map(value -> ResponseEntity
                        .ok()
                        .body(CreateOrderPortInWebMapper.toDto(confirmOrderPortIn.confirm(value, PaymentType.valueOf(body.getPayment())))))
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());

    }

}

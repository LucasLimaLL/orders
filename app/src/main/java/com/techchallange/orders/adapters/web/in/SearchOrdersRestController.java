package com.techchallange.orders.adapters.web.in;

import com.techchallange.orders.core.ports.in.GetOrderPortIn;
import com.techchallange.orders.core.ports.in.SearchOrdersPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SearchOrdersRestController {

    private final SearchOrdersPortIn searchOrdersPortIn;

    @GetMapping(path = "/api/v1/orders")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam(value = "status", required = false) String status) {

        var order = searchOrdersPortIn.search(
                Map.of("status", status)
        );

        return order.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(order);
    }

}

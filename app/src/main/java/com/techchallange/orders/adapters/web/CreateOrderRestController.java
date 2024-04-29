package com.techchallange.orders.adapters.web;

import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class CreateOrderRestController {

    private final CreateOrderPortIn createOrderPortIn;

    @PostMapping
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody String body) {

        return ResponseEntity
                .created(null)
                .build();
    }

}

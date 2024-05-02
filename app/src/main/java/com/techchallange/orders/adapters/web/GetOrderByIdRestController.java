package com.techchallange.orders.adapters.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GetOrderByIdRestController {

    @GetMapping(path = "/api/v1/orders/{id}")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam("id") String id) {

        return ResponseEntity.notFound().build();
    }

}

package com.techchallange.orders.adapters.web;

import com.techchallange.orders.adapters.web.dto.RequestOrderDto;
import com.techchallange.orders.adapters.web.mapper.CreateOrderPortInComboWebMapper;
import com.techchallange.orders.adapters.web.mapper.CreateOrderPortInUserWebMapper;
import com.techchallange.orders.adapters.web.mapper.CreateOrderPortInWebMapper;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class CreateOrderRestController {

    private final CreateOrderPortIn createOrderPortIn;

    @PostMapping(path = "/api/v1/orders")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestOrderDto body) {

        var comboList = CreateOrderPortInComboWebMapper.toDomain(body.getCombos());
        var user = CreateOrderPortInUserWebMapper.toDomain(body.getRequester());

        var order = createOrderPortIn.create(comboList, user);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(CreateOrderPortInWebMapper.toDto(order));
    }

}

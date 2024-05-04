package com.techchallange.orders.adapters.web.in;

import com.techchallange.orders.adapters.web.in.dto.RequestOrderDto;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInComboWebMapper;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInUserWebMapper;
import com.techchallange.orders.adapters.web.in.mapper.CreateOrderPortInWebMapper;
import com.techchallange.orders.core.ports.in.CreateOrderPortIn;
import com.techchallange.orders.core.ports.in.UpdateOrderPortIn;
import com.techchallange.orders.core.usecases.UpdateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UpdateOrderRestController {

    private final UpdateOrderPortIn updateOrderPortIn;

    @PatchMapping(path = "/api/v1/orders/{id}")
    public ResponseEntity<?> update(@RequestHeader Map<String, String> headers,
                                    @PathVariable("id") String id,
                                    @RequestBody RequestOrderDto body) {

        var combo = CreateOrderPortInComboWebMapper.toDomain(body.getCombo());

        var order = updateOrderPortIn.update(id, combo);

        return ResponseEntity
                .ok(CreateOrderPortInWebMapper.toDto(order));
    }

}

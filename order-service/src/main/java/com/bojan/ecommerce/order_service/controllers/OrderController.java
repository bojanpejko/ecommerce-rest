package com.bojan.ecommerce.order_service.controllers;

import com.bojan.ecommerce.order_service.dto.OrderDto;
import com.bojan.ecommerce.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderDto>> listCustomerOrderHistory(@PathVariable String customerId) {
        return ResponseEntity.ok(orderService.listCustomerOrderHistory(customerId));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }
}

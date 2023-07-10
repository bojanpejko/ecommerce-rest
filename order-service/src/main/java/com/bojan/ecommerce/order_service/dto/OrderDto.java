package com.bojan.ecommerce.order_service.dto;

import com.bojan.ecommerce.order_service.enums.Status;

import java.time.Instant;
import java.util.List;

public record OrderDto(
        String uid,
        String customerId,
        Status status,
        String shippingAddress,
        String trackingNumber,
        List<OrderedProductDto> orderedProducts,
        Instant createdAt,
        Instant updatedAt
) {}

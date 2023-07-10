package com.bojan.ecommerce.order_service.dto;

public record OrderedProductDto(OrderDto order, String productUid, Integer quantity) {}

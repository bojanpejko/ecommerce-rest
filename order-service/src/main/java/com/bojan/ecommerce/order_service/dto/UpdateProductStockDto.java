package com.bojan.ecommerce.order_service.dto;

import lombok.Builder;

@Builder
public record UpdateProductStockDto(Integer quantity) {}

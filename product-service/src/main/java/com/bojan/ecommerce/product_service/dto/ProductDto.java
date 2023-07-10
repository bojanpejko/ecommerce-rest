package com.bojan.ecommerce.product_service.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record ProductDto(
      String uid,
      String name,
      String description,
      BigDecimal price,
      String category,
      Integer leftInStock,
      Instant createdAt,
      Instant updatedAt
) {}

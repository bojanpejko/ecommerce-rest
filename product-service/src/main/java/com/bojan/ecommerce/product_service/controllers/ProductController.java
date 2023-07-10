package com.bojan.ecommerce.product_service.controllers;

import com.bojan.ecommerce.product_service.dto.ProductDto;
import com.bojan.ecommerce.product_service.dto.UpdateProductStockDto;
import com.bojan.ecommerce.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{uid}")
    public ResponseEntity<ProductDto> get(@PathVariable String uid) {
        return ResponseEntity.ok(productService.getByUid(uid));
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto dto) {
        productService.createProduct(dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uid}")
    public ResponseEntity<String> updateProductStock(@PathVariable String uid, @RequestBody UpdateProductStockDto dto) {
        productService.updateProductStock(uid, dto);
        return ResponseEntity.ok("");
    }
}

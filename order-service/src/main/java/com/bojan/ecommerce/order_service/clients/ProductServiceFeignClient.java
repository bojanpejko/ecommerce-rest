package com.bojan.ecommerce.order_service.clients;

import com.bojan.ecommerce.order_service.dto.UpdateProductStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service-client", url = "http://localhost:8081/ecommerce/api/v1/products")
public interface ProductServiceFeignClient {

    @PutMapping("/v1/products/{uid}")
    ResponseEntity<String> updateProductStock(@PathVariable String uid, @RequestBody UpdateProductStockDto dto);
}

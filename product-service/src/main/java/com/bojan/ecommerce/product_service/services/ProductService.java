package com.bojan.ecommerce.product_service.services;

import com.bojan.ecommerce.product_service.dto.ProductDto;
import com.bojan.ecommerce.product_service.dto.UpdateProductStockDto;
import com.bojan.ecommerce.product_service.mappers.ProductMapper;
import com.bojan.ecommerce.product_service.models.Product;
import com.bojan.ecommerce.product_service.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto getByUid(String uid) {
        return productMapper.toDto(productRepository.findProductByUid(uid));
    }

    public void createProduct(ProductDto dto) {
        productRepository.save(productMapper.toEntity(dto));
    }

    public void updateProductStock(String uid, UpdateProductStockDto dto) {
        Product product = productRepository.findProductByUid(uid);
        product.setLeftInStock(product.getLeftInStock() - dto.quantity());
        productRepository.save(product);
    }
}

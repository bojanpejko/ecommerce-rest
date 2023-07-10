package com.bojan.ecommerce.product_service.mappers;

import com.bojan.ecommerce.product_service.dto.ProductDto;
import com.bojan.ecommerce.product_service.dto.UpdateProductStockDto;
import com.bojan.ecommerce.product_service.models.Product;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    imports = UUID.class,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ProductMapper {

    @Mapping(target = "uid", expression = "java(UUID.randomUUID().toString())")
    Product toEntity(ProductDto dto);

    ProductDto toDto(Product entity);
}

package com.bojan.ecommerce.order_service.mappers;

import com.bojan.ecommerce.order_service.dto.OrderDto;
import com.bojan.ecommerce.order_service.models.Order;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = OrderedProductMapper.class,
    imports = UUID.class,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface OrderMapper {

    @Mapping(target = "uid", expression = "java(UUID.randomUUID().toString())")
    Order toEntity(OrderDto dto);

    OrderDto toDto(Order entity);
}

package com.bojan.ecommerce.order_service.services;

import com.bojan.ecommerce.order_service.clients.ProductServiceFeignClient;
import com.bojan.ecommerce.order_service.dto.OrderDto;
import com.bojan.ecommerce.order_service.dto.UpdateProductStockDto;
import com.bojan.ecommerce.order_service.mappers.OrderMapper;
import com.bojan.ecommerce.order_service.models.Order;
import com.bojan.ecommerce.order_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductServiceFeignClient productServiceFeignClient;

    public List<OrderDto> listCustomerOrderHistory(String customerId) {
        return orderRepository.findOrdersByCustomerIdOrderByUpdatedAt(customerId)
            .stream()
            .map(orderMapper::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public OrderDto createOrder(OrderDto dto) {
        Order entity = orderRepository.save(orderMapper.toEntity(dto));
        entity.getOrderedProducts().forEach(
            orderedProduct -> productServiceFeignClient.updateProductStock(
                    orderedProduct.getProductUid(), new UpdateProductStockDto(orderedProduct.getQuantity())
            )
        );
        return orderMapper.toDto(entity);
    }
}

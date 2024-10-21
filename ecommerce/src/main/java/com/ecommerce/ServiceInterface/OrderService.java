package com.ecommerce.ServiceInterface;

import com.ecommerce.dto.OrderDto;

public interface OrderService {

	OrderDto createOrderForUser(Long userId, OrderDto orderDto);

	OrderDto createOrder(OrderDto orderDto);

}

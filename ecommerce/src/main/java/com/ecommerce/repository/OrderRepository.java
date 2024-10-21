package com.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.dto.OrderDto;
import com.ecommerce.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	
	

	Order getOrderById(Long id);

	List<Order> findByUserId(Long userId);

	Order save(OrderDto orderDto);

	

	
}

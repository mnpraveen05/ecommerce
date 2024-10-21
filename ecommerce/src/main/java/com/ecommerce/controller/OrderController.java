package com.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderDto;
import com.ecommerce.serviceimpl.OrderServiceimpl;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderServiceimpl orderService;

	 @PostMapping("/create")
	    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {
	        try {
	            orderService.createOrder(orderDto);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Order Successfully Created");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
}
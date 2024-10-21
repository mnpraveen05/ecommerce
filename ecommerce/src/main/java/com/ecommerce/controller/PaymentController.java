package com.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.PaymentDto;
import com.ecommerce.model.Order;
import com.ecommerce.model.Payment;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.serviceimpl.PaymentServiceimpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentServiceimpl paymentService;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository   userRepository;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@GetMapping
	public List<PaymentDto> getAllPayments() {
		return paymentService.getAllPayments().stream().map(payment -> modelMapper.map(payment, PaymentDto.class))
				.collect(Collectors.toList());
	}

	    @PostMapping("/payments")
	    public ResponseEntity<String> createPayment(@RequestBody PaymentDto paymentDto) {
	        try {
	            paymentService.createPayment(paymentDto);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Payment created successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }

	    @GetMapping("/payments/{id}")
	    public ResponseEntity<?> getPayment(@PathVariable Long id) {
	        try {
	            Payment payment = paymentService.getPaymentById(id);
	            return ResponseEntity.ok(payment);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	}
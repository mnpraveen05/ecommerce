package com.ecommerce.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.OrderService;
import com.ecommerce.ServiceInterface.PaymentService;
import com.ecommerce.ServiceInterface.TrackingDetailService;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.dto.PaymentDto;
import com.ecommerce.dto.TrackingDetailDto;
import com.ecommerce.model.Order;
import com.ecommerce.model.Payment;
import com.ecommerce.model.TrackingDetail;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class OrderServiceimpl implements OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderRepository OrderRepository;
	
	
	
	@Autowired
	private TrackingDetailService trackingDetailService;

	@Transactional
	public OrderDto createOrder(OrderDto orderDto) {
	    // Validate the incoming orderDto
	    if (orderDto == null || orderDto.getUserId() == null || orderDto.getProductId() == null) {
	        throw new IllegalArgumentException("OrderDto is invalid");
	    }

	    // Create the payment first
	    PaymentDto paymentDto = new PaymentDto();
	    paymentDto.setUserId(orderDto.getUserId());
	    paymentDto.setProductId(orderDto.getProductId());
	    paymentDto.setAmount(orderDto.getAmount());
	    paymentDto.setMethod(orderDto.getMethod());

	    Payment payment = paymentService.createPayment(paymentDto);

	    // Fetch the user and set it to the orderDto
	    User user = userRepository.findById(orderDto.getUserId())
	        .orElseThrow(() -> new EntityNotFoundException("User not found"));
	    orderDto.setUser(user);

	    // Create the order
	    Order order = modelMapper.map(orderDto, Order.class);
	    order.setPayment(payment); // Set the created payment

	    // Create tracking detail
	    TrackingDetail trackingDetail = new TrackingDetail();
	    trackingDetail.setStatus(orderDto.getStatus());
	    // Any other fields you want to set on trackingDetail

	    // Set the tracking detail to the order
	    order.setTrackingDetail(trackingDetail);

	    // Save the order (which will also save the tracking detail due to cascade)
	    Order savedOrder = orderRepository.save(order);

	    // Map to OrderDto and return
	    return modelMapper.map(savedOrder, OrderDto.class);
	}


	@Override
	public OrderDto createOrderForUser(Long userId, OrderDto orderDto) {
		// TODO Auto-generated method stub
		return null;
	}

}

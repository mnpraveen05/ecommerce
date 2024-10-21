package com.ecommerce.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.PaymentService;
import com.ecommerce.dto.PaymentDto;
import com.ecommerce.model.Payment;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.util.ObjectMapperUtils;

@Service
public class PaymentServiceimpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ModelMapper modelMapper; // For mapping between DTOs and entities

	@Autowired
	private  UserRepository userRepository;
	@Autowired
    private  ProductRepository productRepository;


    
	
	


	@Override
	public List<PaymentDto> getAllPayment() {
		List<Payment> paymentList = paymentRepository.findAll();
		List<PaymentDto> dto = ObjectMapperUtils.mapAll(paymentRepository.findAll(), PaymentDto.class);
		return dto;
	}

	@Override
	public PaymentDto save(Payment payment) {
		Payment savedPayment = paymentRepository.save(payment);
		return modelMapper.map(savedPayment, PaymentDto.class);
	}

	public Collection<PaymentDto> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 @Override
	    public Payment createPayment(PaymentDto paymentDto) {
	        // Fetch User and Product
	        User user = userRepository.findById(paymentDto.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        
	        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ User :"+user.getName());
	        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ paymentDto.getProductId() :"+paymentDto.getProductId());
	        Product p = null;
	        Optional<Product> productO = productRepository.findById(paymentDto.getProductId());
	        
	        System.out.println("############### productO +"+productO.isPresent()); 
	        if(productO.isPresent()) {
	        	p = productO.get();
	        }
	        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@ PPPPPPPPPPPP +"+p.getName());
	        
	        // Map PaymentDto to Payment entity
	        Payment payment = modelMapper.map(paymentDto, Payment.class);
	        payment.setUser(user);
	        payment.setProduct(p);

	        // Save the Payment
	        return paymentRepository.save(payment);
	    }

	    @Override
	    public Payment getPaymentById(Long id) {
	        // Fetch Payment by ID
	        return paymentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Payment not found"));
	    }




	    }

package com.ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;
import com.ecommerce.repository.CartRepository;

@Service
public class CartServiceimpl {
	
	@Autowired
	private CartRepository cartRepository;

	public List<Cart> getAllCart() {
	return cartRepository.findAll();
	}

	
}

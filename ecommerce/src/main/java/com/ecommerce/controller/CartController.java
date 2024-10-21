package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.serviceimpl.CartServiceimpl;

@RestController
@RequestMapping
public class CartController {

	@Autowired
	private CartServiceimpl cartService;
	
	@GetMapping
	public List<Cart>getAllCart(Cart cart){
		return cartService.getAllCart();
	}
	

}

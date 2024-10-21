package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "Amount")
	private double amount;
	@Column(name = "Method")
	private String method;

	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User user;

	// Relationship to Product
	@ManyToOne
	@JoinColumn(name = "productid", nullable = false)
	private Product product;

	public Payment() {
	}

	public Payment(long id, double amount, String method, User user, Product product) {
		this.id = id;
		this.amount = amount;
		this.method = method;
		this.user = user;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void setProductId(Long productId) {
		// TODO Auto-generated method stub
		
	}

	public void setUserId(Long userId) {
		// TODO Auto-generated method stub
		
	}

	


}
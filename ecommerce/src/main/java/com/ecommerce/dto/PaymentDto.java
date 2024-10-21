package com.ecommerce.dto;

public class PaymentDto {

	private long id;
	private double amount;
	private String method;
	private long userId;
	private long productId;

	public PaymentDto() {

	}

	public PaymentDto(long id, double amount, String method, Long userId, Long productId) {
		this.id = id;
		this.amount = amount;
		this.method = method;
		this.userId = userId;
		this.productId = productId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	

}
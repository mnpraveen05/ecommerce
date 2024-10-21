package com.ecommerce.dto;

import java.time.LocalDateTime;

import com.ecommerce.model.TrackingDetail;
import com.ecommerce.model.User;

public class OrderDto {
    private Long id;
    private float orderAmount;
    private LocalDateTime orderDateTime;
    private Long paymentId;
    private double amount;
    private String method;
    private Long userId;
    private Long productId;
    private int trackingDetailId;
    private String status;

	public OrderDto() {

	}

	public OrderDto(Long id, float orderAmount, LocalDateTime orderDateTime, Long paymentId, double amount,
			String method, Long userId, Long productId, int trackingDetailId, String status) {
		this.id = id;
		this.orderAmount = orderAmount;
		this.orderDateTime = orderDateTime;
		this.paymentId = paymentId;
		this.amount = amount;
		this.method = method;
		this.userId = userId;
		this.productId = productId;
		this.trackingDetailId = trackingDetailId;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

	public int getTrackingDetailId() {
		return trackingDetailId;
	}

	public void setTrackingDetailId(int trackingDetailId) {
		this.trackingDetailId = trackingDetailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(User orElseThrow) {
		// TODO Auto-generated method stub
		
	}

	public void setPayment(PaymentDto paymentDto) {
		// TODO Auto-generated method stub
		
	}

	public void setTrackingDetail(TrackingDetail trackingDetail) {
		// TODO Auto-generated method stub
		
	}

	
	
	}
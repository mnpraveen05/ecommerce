package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "amount")
	private float orderAmount;
	
	@Column(name = "OrderDateTime")
	private LocalDateTime orderDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tracking_id")
	private TrackingDetail trackingDetail;
	
	public Order() {
	}

		
	 public Order(long id, float orderAmount, LocalDateTime orderDateTime, User user, Product product, Payment payment,
			TrackingDetail trackingDetail) {
		this.id = id;
		this.orderAmount = orderAmount;
		this.orderDateTime = orderDateTime;
		this.user = user;
		this.product = product;
		this.payment = payment;
		this.trackingDetail = trackingDetail;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public TrackingDetail getTrackingDetail() {
		return trackingDetail;
	}


	public void setTrackingDetail(TrackingDetail trackingDetail) {
		this.trackingDetail = trackingDetail;
	}


	@PrePersist
	  void orderDateTime() {
	    this.orderDateTime = this.orderDateTime = LocalDateTime.now();
	  }

	  
}
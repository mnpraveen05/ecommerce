package com.ecommerce.dto;

public class ProductDto {

	private long id;
	private String name;
	private double price;
	private String description;
	private long orderId;
	

	

	public ProductDto() {
	}

	public ProductDto(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public ProductDto(long id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
}

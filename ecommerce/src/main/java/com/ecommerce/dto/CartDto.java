package com.ecommerce.dto;

public class CartDto {
	private long id;

	public CartDto() {

	}

	public CartDto(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

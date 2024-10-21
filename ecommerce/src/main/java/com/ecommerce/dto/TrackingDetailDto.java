package com.ecommerce.dto;

import com.ecommerce.model.Order;

public class TrackingDetailDto {

	private int id;
	private String status;
	public TrackingDetailDto() {
		
	}
	
	public TrackingDetailDto(int id, String status) {
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOrder(Order savedOrder) {
		// TODO Auto-generated method stub
		
	}

}

package com.ecommerce.dto;

public class AddressDto {

	private long id;
	private String City;
	private String State;
	private String Country;

	public AddressDto() {

	}

	public AddressDto(long id, String city, String state, String country) {
		this.id = id;
		City = city;
		State = state;
		Country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}

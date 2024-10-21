package com.ecommerce.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Address {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "City")
	private String City;
	

	@Column(name = "State")
	private String State;
	@Column(name = "Country")
	private String Country;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
	
	public Address() {
	}
	public Address(long id, String city, String state, String country, User user) {
		this.id = id;
		City = city;
		State = state;
		Country = country;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	}

	



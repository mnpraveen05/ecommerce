package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")


public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Order> orders;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> addresses = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Payment> payments;


	public User() {
	}

	public User(long id, String name, String email, Set<Order> orders, List<Address> addresses) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.orders = orders;
		this.addresses = addresses;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}

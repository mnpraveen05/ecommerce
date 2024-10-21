package com.ecommerce.model;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "Price")
	private double price;
	@Column(name = "Description")
	private String description;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Payment> payments;

	@ManyToOne
	@JoinColumn(name = "category_id")
	// Ensure this matches your database schema
	private ProductCategory productCategory;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Order> orders;

	public Product() {
	}

	public Product(long id, String name, double price, String description, Set<Payment> payments,
			ProductCategory productCategory, Set<Order> orders) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.payments = payments;
		this.productCategory = productCategory;
		this.orders = orders;
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

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	}
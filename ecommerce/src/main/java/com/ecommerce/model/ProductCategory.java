package com.ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "productCategories")
public class ProductCategory {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "Name")
	private String name;

	@OneToMany(mappedBy = "productCategory",  fetch = FetchType.LAZY)
	
    private List<Product> products;
	public ProductCategory() {
	}
	public ProductCategory(long id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
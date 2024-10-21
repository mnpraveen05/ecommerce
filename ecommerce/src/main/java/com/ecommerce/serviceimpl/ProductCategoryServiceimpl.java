package com.ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.ProductCategoryService;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceimpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> getAllProductCategories() {
		return productCategoryRepository.findAll();
	}

	public ProductCategory save(ProductCategory productCategory) {
	
		return productCategoryRepository.save(productCategory);
	}

}

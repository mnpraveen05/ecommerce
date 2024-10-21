package com.ecommerce.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductCategoryDto;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.serviceimpl.ProductCategoryServiceimpl;

@RestController
@RequestMapping("/productCategories")
public class ProductCategoryController {
@Autowired
private ModelMapper modelMapper;
@Autowired
private ProductCategoryRepository  productCategoryRepository;

@Autowired
private ProductCategoryServiceimpl productCategoryService;

@GetMapping
public List<ProductCategory>getAllProductCategories(ProductCategory productCategory){
return productCategoryService.getAllProductCategories();
}


@PostMapping("/createProductCategory")
public ResponseEntity<ProductCategoryDto> createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
	try {
		System.out.println("Incoming ProductCategoryDto: " + productCategoryDto);

		// Validate ProductCategoryDto
		if (productCategoryDto == null) {
			return ResponseEntity.badRequest().body(null);
		}

		// Map ProductCategoryDto to ProductCategory entity
		ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);

		// Save the ProductCategory
		ProductCategory savedProductCategory = productCategoryService.save(productCategory);

		// Map saved ProductCategory back to ProductCategoryDto for response
		ProductCategoryDto productCategoryResponse = modelMapper.map(savedProductCategory, ProductCategoryDto.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryResponse);
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
}
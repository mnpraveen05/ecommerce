package com.ecommerce.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.serviceimpl.ProductServiceimpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductServiceimpl productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	
	

@PostMapping(value = "/createProductForProductCategory/{productCategoryId}")
public ResponseEntity<ProductDto> createProductForProductCategory(@RequestBody ProductDto productDto,
        @PathVariable(name = "productCategoryId") Long productCategoryId) {
    try {
        // 1. Validate ProductCategory ID
        if (productCategoryId <= 0 || !productCategoryRepository.existsById(productCategoryId)) {
            return ResponseEntity.badRequest().body(null);
        }

        // 2. Retrieve ProductCategory and set in Product
        ProductCategory productCategory = productCategoryRepository.findById(productCategoryId)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));

        // 3. Map ProductDto to Product entity
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDto, Product.class);
        product.setProductCategory(productCategory); // Set the ProductCategory reference

        // 4. Save the Product
        Product savedProduct = productService.save(product);

        // Map saved Product entity back to ProductDto
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDto);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}



}
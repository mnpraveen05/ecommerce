package com.ecommerce.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.ProductService;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.exception.ProductCategoryNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceimpl implements ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private ProductCategoryRepository productCategoryRepository; // Change to ProductCategoryRepository

	    @Autowired
	    private ModelMapper modelMapper;

		@Override
		public ProductDto createProduct(ProductDto productDto) {
			// TODO Auto-generated method stub
			return null;
		}

		public Product save(Product product) {
			// TODO Auto-generated method stub
			return productRepository.save(product);
		}



	}

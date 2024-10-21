package com.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ServiceInterface.AddressService;
import com.ecommerce.dto.AddressDto;
import com.ecommerce.model.Address;
import com.ecommerce.model.User;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class AddressController {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<AddressDto> getAllAddress() {
		return addressService.getAllAddress().stream().map(address -> modelMapper.map(address, AddressDto.class))
				.collect(Collectors.toList());

	}
	@PostMapping(value = "/createAddressForUser/{userId}")
	public ResponseEntity<AddressDto> createAddressForUser(@RequestBody AddressDto addressDto,
	        @PathVariable(name = "userId") Long userId) {
	    try {
	        // 1. Validate User ID
	        if (userId <= 0 || !userRepository.existsById(userId)) {
	            return ResponseEntity.badRequest().body(null);
	        }

	        // 2. Retrieve User and set in Address
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        // 3. Map AddressDto to Address entity
	        ModelMapper modelMapper = new ModelMapper();
	        Address address = modelMapper.map(addressDto, Address.class);
	        address.setUser(user); // Set the user reference

	        // 4. Save the Address
	        Address savedAddress = addressService.save(address);

	        // Map saved Address entity back to AddressDto
	        AddressDto savedAddressDto = modelMapper.map(savedAddress, AddressDto.class);

	        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddressDto);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

}

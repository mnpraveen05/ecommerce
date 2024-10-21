package com.ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ServiceInterface.AddressService;
import com.ecommerce.dto.AddressDto;
import com.ecommerce.model.Address;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.util.ObjectMapperUtils;

@Service
public class AddressServiceimpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<AddressDto> getAllAddress() {
		List<Address> AddressList = addressRepository.findAll();
		List<AddressDto> dto = ObjectMapperUtils.mapAll(addressRepository.findAll(), AddressDto.class);
		return dto;
	}
	@Override
    public Address save(Address address) {
        // Perform any additional logic or validation if necessary
        return addressRepository.save(address); // Save the address to the database
    }
}




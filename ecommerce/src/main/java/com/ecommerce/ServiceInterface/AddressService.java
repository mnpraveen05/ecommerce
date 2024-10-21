package com.ecommerce.ServiceInterface;

import java.util.List;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.model.Address;

public interface AddressService {

	List<AddressDto> getAllAddress();

	Address save(Address address);

}

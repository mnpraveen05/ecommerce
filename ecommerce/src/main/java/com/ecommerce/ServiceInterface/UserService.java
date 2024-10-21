package com.ecommerce.ServiceInterface;

import java.util.Collection;
import java.util.List;

import com.ecommerce.dto.UserDto;
import com.ecommerce.model.User;

public interface UserService {

	UserDto getUserById(Long id);

	List<UserDto> getAllUsers();

	User save(User user);

}

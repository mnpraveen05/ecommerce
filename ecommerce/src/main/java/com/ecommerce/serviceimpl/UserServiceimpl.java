package com.ecommerce.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ServiceInterface.UserService;
import com.ecommerce.dto.UserDto;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.util.ObjectMapperUtils;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	// @Autowired
	// private ObjectMapperUtils modelMapper;

	public UserServiceimpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDto getUserById(Long id) {
		// Retrieve the user from the repository
		User user = userRepository.getUserByid(id); // Make sure to pass the ID

		// Check if the user was found
		if (user == null) {
			throw new RuntimeException("User not found with ID: " + id); // Handle as appropriate
		}

		// Map the User entity to UserDto
		UserDto dto = ObjectMapperUtils.map(user, UserDto.class);
		return dto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepository.findAll();
		//System.out.println("&&&&&&&&&&&&&&&rrrrrrrrrrrrrrrrrrrr " + userList.size());
		List<UserDto> dto = ObjectMapperUtils.mapAll(userRepository.findAll(), UserDto.class);
		return dto;
	}

	@Override
	public User save(User user) {
		if(user==null ||user.getName()==null ||user.getEmail()==null) {
			throw new IllegalArgumentException("user Information is incomplete");
		}
		return userRepository.save(user);
	}

}

/*
 * public User saveUser(User user) {
 * 
 * return userRepository.save(user); }
 * 
 * public User getUserWithOrders(Long userId) { // Retrieve the user and
 * initialize orders User user = userRepository.findById(userId).orElseThrow(()
 * -> new RuntimeException("User not found"));
 * 
 * // Initialize the orders collection Hibernate.initialize(user.getOrders());
 * 
 * return user; }
 */

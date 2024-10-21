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

import com.ecommerce.ServiceInterface.UserService;
import com.ecommerce.dto.UserDto;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private ModelMapper modelMapper;

	private UserRepository userRepository;

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<UserDto> getAllPosts() {

		return userService.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	/*
	 * @GetMapping public List<UserDto> getAllUser() {
	 * System.out.println("Praveeeeeeeeeeeeeeeeeen"); return
	 * userService.getAllUser(); }
	 */

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
		UserDto user = userService.getUserById(id);
		UserDto userResponse = modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok().body(userResponse);

	}

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		try {
			System.out.println("Incoming UserDto: " + userDto);

			// Validate userDto
			if (userDto == null) {
				return ResponseEntity.badRequest().body(null);
			}

			// Map UserDto to User entity
			User user = modelMapper.map(userDto, User.class);

			// Save the user
			User savedUser = userService.save(user);

			// Map saved User back to UserDto for response
			UserDto userResponse = modelMapper.map(savedUser, UserDto.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
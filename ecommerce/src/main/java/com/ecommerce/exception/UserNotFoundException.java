package com.ecommerce.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    } 

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}

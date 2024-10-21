package com.ecommerce.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }

	public PaymentNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}

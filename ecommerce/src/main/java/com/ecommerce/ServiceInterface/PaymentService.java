package com.ecommerce.ServiceInterface;

import java.util.List;

import com.ecommerce.dto.PaymentDto;
import com.ecommerce.model.Payment;

public interface PaymentService {

	List<PaymentDto> getAllPayment();

	PaymentDto save(Payment payment);

	Payment createPayment(PaymentDto paymentDto);

	Payment getPaymentById(Long id);

}

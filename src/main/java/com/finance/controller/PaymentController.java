package com.finance.controller;

import com.finance.generic.UserIndependent.UserIndependentController;
import com.finance.generic.UserIndependent.UserIndependentService;
import com.finance.model.Payment;
import com.finance.payload.request.PaymentRequest;
import com.finance.payload.response.PaymentResponse;
import com.finance.repository.PaymentRepository;
import com.finance.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController extends UserIndependentController<Payment, PaymentResponse, PaymentRequest, PaymentService, PaymentRepository, String> {
    public PaymentController(PaymentService service) {
        super(service);
    }
}

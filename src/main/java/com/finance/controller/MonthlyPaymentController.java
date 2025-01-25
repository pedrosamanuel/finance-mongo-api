package com.finance.controller;

import com.finance.generic.UserDependent.UserDependentController;
import com.finance.model.MonthlyPayment;
import com.finance.payload.request.MonthlyPaymentRequest;
import com.finance.payload.response.MonthlyPaymentResponse;
import com.finance.repository.MonthlyPaymentRepository;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.MonthlyPaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/monthlyPayment")
public class MonthlyPaymentController extends UserDependentController<MonthlyPayment, MonthlyPaymentResponse,
        MonthlyPaymentRequest, MonthlyPaymentService, MonthlyPaymentRepository, String> {

    protected MonthlyPaymentController(MonthlyPaymentService service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        super(service, jwtUtils, userDetailsService);
    }
}

package com.finance.controller;

import com.finance.generic.UserDependent.UserDependentController;
import com.finance.model.Expense;
import com.finance.payload.request.ExpenseRequest;
import com.finance.payload.response.ExpenseResponse;
import com.finance.repository.ExpenseRepository;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController extends UserDependentController<Expense, ExpenseResponse, ExpenseRequest, ExpenseService, ExpenseRepository, String> {

    protected ExpenseController(ExpenseService service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        super(service, jwtUtils, userDetailsService);
    }


}

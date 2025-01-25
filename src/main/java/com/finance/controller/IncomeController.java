package com.finance.controller;

import com.finance.generic.UserDependent.UserDependentController;
import com.finance.model.Income;
import com.finance.payload.request.IncomeRequest;
import com.finance.payload.response.IncomeResponse;
import com.finance.repository.IncomeRepository;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.IncomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/income")
public class IncomeController extends UserDependentController<Income, IncomeResponse,
        IncomeRequest, IncomeService, IncomeRepository, String> {
    protected IncomeController(IncomeService service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        super(service, jwtUtils, userDetailsService);
    }
}

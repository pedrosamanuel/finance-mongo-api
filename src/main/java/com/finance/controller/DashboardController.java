package com.finance.controller;

import com.finance.payload.response.ExpenseByCategoryResponse;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsImpl;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;

    public DashboardController(DashboardService dashboardService, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        this.dashboardService = dashboardService;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }
    @GetMapping("/expenseByCategory")
    public ResponseEntity<List<ExpenseByCategoryResponse>> getExpenseByCategory(
            @CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
        return ResponseEntity.ok(dashboardService.getExpenseByCategory(userDetails.getId()));
    }
}

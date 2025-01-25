package com.finance.controller;

import com.finance.payload.request.CategoryRequest;
import com.finance.payload.response.CategoryResponse;
import com.finance.generic.UserDependent.UserDependentController;
import com.finance.model.Category;
import com.finance.repository.CategoryRepository;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends UserDependentController<Category, CategoryResponse, CategoryRequest, CategoryService, CategoryRepository, String> {
    protected CategoryController(CategoryService service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        super(service, jwtUtils, userDetailsService);
    }
}

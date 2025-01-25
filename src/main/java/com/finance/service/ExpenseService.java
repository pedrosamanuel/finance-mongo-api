package com.finance.service;

import com.finance.generic.UserDependent.UserDependentService;
import com.finance.model.Category;
import com.finance.model.Expense;
import com.finance.payload.request.ExpenseRequest;
import com.finance.payload.response.CategoryResponse;
import com.finance.payload.response.ExpenseResponse;
import com.finance.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService extends UserDependentService<Expense, ExpenseResponse, ExpenseRequest, ExpenseRepository, String> {

    private final CategoryService categoryService;

    public ExpenseService(ExpenseRepository repository, CategoryService categoryService) {
        super(repository);
        this.categoryService = categoryService;
    }

    @Override
    protected Expense createEntity(ExpenseRequest request, String userId) {
        return Expense.builder()
                .amount(request.getAmount())
                .categoryId(request.getCategoryId())
                .description(request.getDescription())
                .userId(userId)
                .build();
    }

    @Override
    protected Expense setActiveFalse(Expense entity) {
        entity.setActive(false);
        return entity;
    }

    @Override
    protected Expense updateEntity(Expense entity, ExpenseRequest requestUpdate) {
        entity.setAmount(requestUpdate.getAmount());
        entity.setCategoryId(requestUpdate.getCategoryId());
        entity.setDescription(requestUpdate.getDescription());
        return entity;
    }

    @Override
    protected ExpenseResponse convertToResponse(Expense entity) {
        ExpenseResponse res = new ExpenseResponse();
        res.setId(entity.getId());
        res.setAmount(entity.getAmount());
        res.setDescription(entity.getDescription());
        Optional<Category> category = categoryService.findById(entity.getCategoryId());
        category.ifPresent(cat -> {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(cat.getId());
            categoryResponse.setName(cat.getName());
            res.setCategory(categoryResponse);
        });
        return res;
    }
}

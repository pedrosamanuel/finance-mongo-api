package com.finance.service;

import com.finance.payload.response.ExpenseByCategoryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {
    private final ExpenseService expenseService;
    public DashboardService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    public List<ExpenseByCategoryResponse> getExpenseByCategory(String userId){
        LocalDate date = LocalDate.now();
        int month = date.getMonth().getValue();
        int year = date.getYear();
        return expenseService.getExpenseByCategory(userId, month, year);
    }
}

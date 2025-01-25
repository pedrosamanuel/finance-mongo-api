package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.Expense;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends UserDependentRepository<Expense, String> {
}

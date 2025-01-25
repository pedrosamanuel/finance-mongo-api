package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.Income;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends UserDependentRepository<Income, String > {
}

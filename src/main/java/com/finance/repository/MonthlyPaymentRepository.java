package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.MonthlyPayment;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyPaymentRepository extends UserDependentRepository<MonthlyPayment, String> {
}

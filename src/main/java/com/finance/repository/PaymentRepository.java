package com.finance.repository;

import com.finance.generic.UserIndependent.UserIndependentRepository;
import com.finance.model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends UserIndependentRepository<Payment, String> {
}

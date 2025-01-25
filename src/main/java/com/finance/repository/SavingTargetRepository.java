package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.SavingTarget;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingTargetRepository extends UserDependentRepository<SavingTarget, String> {
}

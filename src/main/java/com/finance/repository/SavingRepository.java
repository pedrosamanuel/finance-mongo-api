package com.finance.repository;

import com.finance.generic.UserIndependent.UserIndependentRepository;
import com.finance.model.Saving;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingRepository extends UserIndependentRepository<Saving, String> {
    List<Saving> findBySavingTargetId(String savingTargetId);
}

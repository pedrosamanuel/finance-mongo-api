package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends UserDependentRepository<Category, String> {
}

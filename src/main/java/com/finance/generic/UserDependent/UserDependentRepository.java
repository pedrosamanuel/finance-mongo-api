package com.finance.generic.UserDependent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface UserDependentRepository<T,ID> extends MongoRepository<T, ID> {

    List<T> findAllByUserIdAndIsActiveTrue(String userId);

    Optional<T> findByIdAndUserIdAndIsActiveTrue(ID id, String userId);
}

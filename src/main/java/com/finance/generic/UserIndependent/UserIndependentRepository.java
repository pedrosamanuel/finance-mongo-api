package com.finance.generic.UserIndependent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.yaml.snakeyaml.events.Event;

@NoRepositoryBean
public interface UserIndependentRepository<T,ID> extends MongoRepository<T, ID> {
}

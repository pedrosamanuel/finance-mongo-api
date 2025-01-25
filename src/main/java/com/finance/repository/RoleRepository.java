package com.finance.repository;

import java.util.Optional;

import com.finance.model.ERole;
import com.finance.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}

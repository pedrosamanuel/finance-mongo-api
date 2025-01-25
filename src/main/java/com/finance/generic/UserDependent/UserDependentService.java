package com.finance.generic.UserDependent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class UserDependentService<T, RES, REQ, R extends UserDependentRepository<T,ID>, ID> {
    private final R repository;

    public UserDependentService(R repository) {
        this.repository = repository;
    }
    public List<RES> findAll(String userId) {
        List<T> list = repository.findAllByUserIdAndIsActiveTrue(userId);
        return list.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<RES> findByIdDTO(String userId , ID id) {
        Optional<T> entity = repository.findByIdAndUserIdAndIsActiveTrue(id, userId);
        return entity.map(this::convertToResponse);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public void save(REQ req, String userId) {
        repository.save(createEntity(req, userId));
    }

    public Boolean deleteById(String userId, ID id) {
        Optional<T> existingEntity = repository.findByIdAndUserIdAndIsActiveTrue(id, userId);
        if (existingEntity.isPresent()) {
            repository.save(setActiveFalse(existingEntity.get()));
            return true;
        }
        return false;
    }

    public Boolean update(String userId, ID id, REQ requestUpdate) {
        Optional<T> existingEntity = repository.findByIdAndUserIdAndIsActiveTrue(id, userId);
        if (existingEntity.isPresent()) {
            T entity = existingEntity.get();
            T updated = updateEntity(entity, requestUpdate);
            repository.save(updated);
            return true;
        }
        return false;
    }
    protected abstract T createEntity(REQ request, String userId);
    protected abstract T setActiveFalse(T entity);
    protected abstract T updateEntity(T entity, REQ requestUpdate);
    protected abstract RES convertToResponse(T entity);
}

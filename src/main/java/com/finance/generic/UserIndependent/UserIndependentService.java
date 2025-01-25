package com.finance.generic.UserIndependent;

import com.finance.generic.UserDependent.UserDependentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class UserIndependentService<T, RES, REQ, R extends UserIndependentRepository<T,ID>, ID> {
    private final R repository;
    public UserIndependentService(R repository) {
        this.repository = repository;
    }


    public List<RES> findAll() {
        List<T> list = repository.findAll();
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<RES> findByIdDTO(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(this::convertToDTO);
    }
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }


    public void save(REQ request) {
        repository.save(createEntity(request));
    }

    public Boolean deleteById(ID id) {
        Optional<T> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean update(ID id, REQ requestUpdate) {
        Optional<T> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
            T entity = existingEntity.get();
            T updated = updateEntity(entity, requestUpdate);
            repository.save(updated);
            return true;
        }
        return false;
    }
    protected abstract T createEntity(REQ request);
    protected abstract T updateEntity(T entity, REQ requestUpdate);
    protected abstract RES convertToDTO(T entity);
}
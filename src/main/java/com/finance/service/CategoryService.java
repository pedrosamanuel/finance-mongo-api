package com.finance.service;


import com.finance.payload.request.CategoryRequest;
import com.finance.payload.response.CategoryResponse;
import com.finance.generic.UserDependent.UserDependentService;
import com.finance.model.Category;
import com.finance.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends UserDependentService<Category, CategoryResponse, CategoryRequest ,CategoryRepository, String> {
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    @Override
    protected Category createEntity(CategoryRequest request, String userId) {
        return Category.builder()
                .name(request.getName())
                .userId(userId)
                .build();
    }

    @Override
    protected Category setActiveFalse(Category entity) {
        entity.setActive(false);
        return entity;
    }

    @Override
    protected Category updateEntity(Category entity, CategoryRequest requestUpdate) {
        entity.setName(requestUpdate.getName());
        return entity;
    }

    @Override
    protected CategoryResponse convertToResponse(Category entity) {
        CategoryResponse res= new CategoryResponse();
        res.setId(entity.getId());
        res.setName(entity.getName());
        return res;
    }
}

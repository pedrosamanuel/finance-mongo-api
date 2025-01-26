package com.finance.service;

import com.finance.generic.UserDependent.UserDependentService;
import com.finance.model.Income;
import com.finance.payload.request.IncomeRequest;
import com.finance.payload.response.IncomeResponse;
import com.finance.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class IncomeService extends UserDependentService<Income, IncomeResponse, IncomeRequest, IncomeRepository, String> {
    public IncomeService(IncomeRepository repository) {
        super(repository);
    }

    @Override
    protected Income createEntity(IncomeRequest request, String userId) {
        return Income.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .date(Date.valueOf(LocalDate.now()))
                .userId(userId)
                .build();
    }

    @Override
    protected Income setActiveFalse(Income entity) {
        entity.setActive(false);
        return entity;
    }

    @Override
    protected Income updateEntity(Income entity, IncomeRequest requestUpdate) {
        entity.setAmount(requestUpdate.getAmount());
        entity.setDescription(requestUpdate.getDescription());
        return entity;
    }

    @Override
    protected IncomeResponse convertToResponse(Income entity) {
        IncomeResponse res = new IncomeResponse();
        res.setId(entity.getId());
        res.setAmount(entity.getAmount());
        res.setDescription(entity.getDescription());
        res.setDate(entity.getDate());
        return res;
    }
}

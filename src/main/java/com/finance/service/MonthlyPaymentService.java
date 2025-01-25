package com.finance.service;

import com.finance.generic.UserDependent.UserDependentService;
import com.finance.model.MonthlyPayment;
import com.finance.payload.request.MonthlyPaymentRequest;
import com.finance.payload.response.MonthlyPaymentResponse;
import com.finance.repository.MonthlyPaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class MonthlyPaymentService extends UserDependentService<MonthlyPayment, MonthlyPaymentResponse,
        MonthlyPaymentRequest, MonthlyPaymentRepository, String> {

    public MonthlyPaymentService(MonthlyPaymentRepository repository) {
        super(repository);
    }

    @Override
    protected MonthlyPayment createEntity(MonthlyPaymentRequest request, String userId) {
        return MonthlyPayment.builder()
                .description(request.getDescription())
                .dayFrom(request.getDayFrom())
                .dayTo(request.getDayTo())
                .userId(userId)
                .build();
    }

    @Override
    protected MonthlyPayment setActiveFalse(MonthlyPayment entity) {
        entity.setActive(false);
        return entity;
    }

    @Override
    protected MonthlyPayment updateEntity(MonthlyPayment entity, MonthlyPaymentRequest requestUpdate) {
        entity.setDescription(requestUpdate.getDescription());
        entity.setDayFrom(requestUpdate.getDayFrom());
        entity.setDayTo(requestUpdate.getDayTo());
        return entity;
    }

    @Override
    protected MonthlyPaymentResponse convertToResponse(MonthlyPayment entity) {
        MonthlyPaymentResponse res = new MonthlyPaymentResponse();
        res.setId(entity.getId());
        res.setDescription(entity.getDescription());
        res.setDayFrom(entity.getDayFrom());
        res.setDayTo(entity.getDayTo());
        return res;
    }
}

package com.finance.service;

import com.finance.generic.UserDependent.UserDependentService;
import com.finance.model.Saving;
import com.finance.model.SavingTarget;
import com.finance.payload.request.SavingTargetRequest;
import com.finance.payload.response.SavingTargetResponse;
import com.finance.repository.SavingTargetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingTargetService extends UserDependentService<SavingTarget, SavingTargetResponse,
        SavingTargetRequest, SavingTargetRepository, String> {
    private final SavingService savingService;
    private final SavingTargetRepository savingTargetRepository;
    public SavingTargetService(SavingService savingService, SavingTargetRepository savingTargetRepository) {
        super(savingTargetRepository);
        this.savingService = savingService;
        this.savingTargetRepository = savingTargetRepository;
    }
    public float getSavingProgress(String id){
        List<Saving> actualSavings = savingService.findBySavingTargetId(id);
        float amountSaved = 0;
        float amountTarget = 0;
        for(Saving s : actualSavings){
            amountSaved += s.getAmount();
        }
        Optional<SavingTarget> savingTargetOptional = savingTargetRepository.findById(id);
        if(savingTargetOptional.isPresent()){
            amountTarget = savingTargetOptional.get().getAmount();
        }
        if (amountTarget == 0) return 0;

        return ( amountSaved / amountTarget ) * 100;
    }

    @Override
    protected SavingTarget createEntity(SavingTargetRequest request, String userId) {
        return SavingTarget.builder()
                .amount(request.getAmount())
                .deadlineDate(request.getDeadlineDate())
                .description(request.getDescription())
                .userId(userId)
                .build();
    }

    @Override
    protected SavingTarget setActiveFalse(SavingTarget entity) {
        entity.setActive(false);
        return entity;
    }

    @Override
    protected SavingTarget updateEntity(SavingTarget entity, SavingTargetRequest requestUpdate) {
        entity.setAmount(requestUpdate.getAmount());
        entity.setDeadlineDate(requestUpdate.getDeadlineDate());
        entity.setDescription(requestUpdate.getDescription());
        return entity;
    }

    @Override
    protected SavingTargetResponse convertToResponse(SavingTarget entity) {
        SavingTargetResponse res = new SavingTargetResponse();
        res.setId(entity.getId());
        res.setAmount(entity.getAmount());
        res.setDescription(entity.getDescription());
        res.setDeadlineDate(entity.getDeadlineDate());
        return res;
    }
}

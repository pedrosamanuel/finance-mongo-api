package com.finance.service;

import com.finance.generic.UserIndependent.UserIndependentService;
import com.finance.model.Saving;
import com.finance.model.SavingTarget;
import com.finance.payload.request.SavingRequest;
import com.finance.payload.response.SavingResponse;
import com.finance.payload.response.SavingTargetResponse;
import com.finance.repository.SavingRepository;
import com.finance.repository.SavingTargetRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SavingService extends UserIndependentService<Saving, SavingResponse, SavingRequest, SavingRepository, String> {
    private final SavingTargetRepository savingTargetRepository;
    private final SavingRepository savingRepository;
    public SavingService(SavingTargetRepository savingTargetRepository, SavingRepository savingRepository) {
        super(savingRepository);
        this.savingTargetRepository = savingTargetRepository;
        this.savingRepository = savingRepository;
    }

    public List<Saving> findBySavingTargetId(String savingTargetId){
        return savingRepository.findBySavingTargetId(savingTargetId);
    }

    @Override
    protected Saving createEntity(SavingRequest request) {
        return Saving.builder()
                .amount(request.getAmount())
                .date(Date.valueOf(LocalDate.now()))
                .savingTargetId(request.getSavingTargetId())
                .build();
    }

    @Override
    protected Saving updateEntity(Saving entity, SavingRequest requestUpdate) {
        entity.setAmount(requestUpdate.getAmount());
        return entity;
    }

    @Override
    protected SavingResponse convertToDTO(Saving entity) {
        SavingResponse res = new SavingResponse();
        res.setId(entity.getId());
        res.setAmount(entity.getAmount());
        res.setDate(entity.getDate());
        Optional<SavingTarget> savingTarget = savingTargetRepository.findById(entity.getSavingTargetId());
        savingTarget.ifPresent(st -> {
            SavingTargetResponse savingTargetResponse = new SavingTargetResponse();
            savingTargetResponse.setAmount(st.getAmount());
            savingTargetResponse.setDeadlineDate(st.getDeadlineDate());
            savingTargetResponse.setDescription(st.getDescription());
            savingTargetResponse.setId(st.getId());
            res.setSavingTarget(savingTargetResponse);
        });
        return res;
    }
}

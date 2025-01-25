package com.finance.controller;

import com.finance.generic.UserIndependent.UserIndependentController;
import com.finance.model.Saving;
import com.finance.payload.request.SavingRequest;
import com.finance.payload.response.SavingResponse;
import com.finance.repository.SavingRepository;
import com.finance.service.SavingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saving")
public class SavingController extends UserIndependentController<Saving, SavingResponse, SavingRequest,
        SavingService, SavingRepository, String> {
    public SavingController(SavingService service) {
        super(service);
    }
}

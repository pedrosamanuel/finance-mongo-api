package com.finance.controller;

import com.finance.generic.UserDependent.UserDependentController;
import com.finance.model.Saving;
import com.finance.model.SavingTarget;
import com.finance.payload.request.SavingTargetRequest;
import com.finance.payload.response.SavingTargetResponse;
import com.finance.repository.SavingTargetRepository;
import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsServiceImpl;
import com.finance.service.SavingTargetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/savingTarget")
public class SavingTargetController extends UserDependentController<SavingTarget, SavingTargetResponse,
        SavingTargetRequest, SavingTargetService, SavingTargetRepository, String> {

    private final SavingTargetService savingTargetService;
    protected SavingTargetController(SavingTargetService service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService, SavingTargetService savingTargetService) {
        super(service, jwtUtils, userDetailsService);
        this.savingTargetService = savingTargetService;
    }

@GetMapping("/{id}/progress")
    public ResponseEntity<Float> getSavingProgress (@PathVariable("id") String id){
        Float progress = savingTargetService.getSavingProgress(id);
        return ResponseEntity.ok(progress);
    }

}

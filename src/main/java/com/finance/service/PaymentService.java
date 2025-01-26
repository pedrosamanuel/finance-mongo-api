package com.finance.service;

import com.finance.generic.UserIndependent.UserIndependentService;
import com.finance.model.MonthlyPayment;
import com.finance.model.Payment;
import com.finance.payload.request.PaymentRequest;
import com.finance.payload.response.MonthlyPaymentResponse;
import com.finance.payload.response.PaymentResponse;
import com.finance.repository.MonthlyPaymentRepository;
import com.finance.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService extends UserIndependentService<Payment, PaymentResponse, PaymentRequest, PaymentRepository, String>{
    private final MonthlyPaymentService monthlyPaymentService;
    public PaymentService(PaymentRepository repository, MonthlyPaymentRepository monthlyPaymentRepository, MonthlyPaymentService monthlyPaymentService) {
        super(repository);

        this.monthlyPaymentService = monthlyPaymentService;
    }

    @Override
    protected Payment createEntity(PaymentRequest request) {
        return Payment.builder()
                .amount(request.getAmount())
                .date(Date.valueOf(LocalDate.now()))
                .monthlyPaymentId(request.getMonthlyPaymentId())
                .build();
    }

    @Override
    protected Payment updateEntity(Payment entity, PaymentRequest requestUpdate) {
        entity.setAmount(requestUpdate.getAmount());
        return entity;
    }

    @Override
    protected PaymentResponse convertToDTO(Payment entity) {
        PaymentResponse response = new PaymentResponse();
        response.setId(entity.getId());
        response.setAmount(entity.getAmount());
        response.setDate(entity.getDate());
        Optional<MonthlyPayment> monthlyPayment = monthlyPaymentService.findById(entity.getMonthlyPaymentId());
        monthlyPayment.ifPresent(mp -> {
            MonthlyPaymentResponse monthlyPaymentResponse = new MonthlyPaymentResponse();
            monthlyPaymentResponse.setId(mp.getId());
            monthlyPaymentResponse.setDescription(mp.getDescription());
            monthlyPaymentResponse.setDayTo(mp.getDayTo());
            monthlyPaymentResponse.setDayFrom(mp.getDayFrom());
            response.setMonthlyPayment(monthlyPaymentResponse);
        });
        return response;
    }
}

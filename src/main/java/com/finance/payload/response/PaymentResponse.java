package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentResponse extends BaseResponse<String> {
    private float amount;
    private LocalDate date;
    private MonthlyPaymentResponse monthlyPayment;
}

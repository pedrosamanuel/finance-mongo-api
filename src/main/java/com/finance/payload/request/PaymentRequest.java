package com.finance.payload.request;

import lombok.Data;


@Data
public class PaymentRequest {
    private float amount;
    private String monthlyPaymentId;
}

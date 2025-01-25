package com.finance.payload.request;

import lombok.Data;

@Data
public class MonthlyPaymentRequest {
    private String description;
    private int dayFrom;
    private int dayTo;
}

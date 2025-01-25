package com.finance.payload.request;

import lombok.Data;

@Data
public class IncomeRequest {
    private float amount;
    private String description;
}

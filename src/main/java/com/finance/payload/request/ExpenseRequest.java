package com.finance.payload.request;

import lombok.Data;

@Data
public class ExpenseRequest {
    private float amount;
    private String description;
    private String categoryId;
}

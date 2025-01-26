package com.finance.payload.response;

import lombok.Data;

@Data
public class ExpenseByCategoryResponse {
    private CategoryResponse category;
    private float totalAmount;
}

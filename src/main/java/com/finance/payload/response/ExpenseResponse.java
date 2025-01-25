package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExpenseResponse extends BaseResponse<String> {
    private float amount;
    private String description;
    private CategoryResponse category;
}

package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;

@Data
public class IncomeResponse extends BaseResponse<String> {
    private float amount;
    private String description;
}

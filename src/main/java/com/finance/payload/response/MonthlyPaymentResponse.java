package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonthlyPaymentResponse extends BaseResponse<String> {
    private String description;
    private int dayFrom;
    private int dayTo;
}

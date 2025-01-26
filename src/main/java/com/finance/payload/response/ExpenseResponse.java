package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExpenseResponse extends BaseResponse<String> {
    private float amount;
    private String description;
    private Date date;
    private CategoryResponse category;
}

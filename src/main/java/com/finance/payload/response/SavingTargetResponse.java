package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SavingTargetResponse extends BaseResponse<String> {
    private String description;
    private float amount;
    private Date deadlineDate;
}

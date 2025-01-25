package com.finance.payload.response;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.finance.generic.BaseResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SavingResponse extends BaseResponse<String> {
    private float amount;
    private LocalDate date;
    private SavingTargetResponse savingTarget;
}

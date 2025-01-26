package com.finance.payload.response;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.finance.generic.BaseResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SavingResponse extends BaseResponse<String> {
    private float amount;
    private Date date;
    private SavingTargetResponse savingTarget;
}

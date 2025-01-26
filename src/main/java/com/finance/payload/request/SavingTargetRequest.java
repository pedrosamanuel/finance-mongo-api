package com.finance.payload.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SavingTargetRequest {
    private String description;
    private float amount;
    private Date deadlineDate;
}

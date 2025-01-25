package com.finance.payload.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SavingTargetRequest {
    private String description;
    private float amount;
    private LocalDate deadlineDate;
}

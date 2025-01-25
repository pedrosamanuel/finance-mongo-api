package com.finance.payload.request;

import lombok.Data;

@Data
public class SavingRequest {
    private float amount;
    private String savingTargetId;
}

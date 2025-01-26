package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PaymentResponse extends BaseResponse<String> {
    private float amount;
    private Date date;
    private MonthlyPaymentResponse monthlyPayment;
}

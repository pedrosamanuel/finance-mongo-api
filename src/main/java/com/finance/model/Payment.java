package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "payment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseDocument<String> {
    private float amount;
    private Date date;
    private String monthlyPaymentId;
}

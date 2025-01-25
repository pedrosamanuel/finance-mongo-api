package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "payment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseDocument<String> {
    private float amount;
    private LocalDate date;
    private String monthlyPaymentId;
}

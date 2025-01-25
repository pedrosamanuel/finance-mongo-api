package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "monthlyPayment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyPayment extends BaseDocument<String>{
    private String description;
    private int dayFrom;
    private int dayTo;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

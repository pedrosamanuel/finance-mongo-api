package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "expense")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseDocument<String> {
    private float amount;
    private String description;
    private Date date;
    private String categoryId;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

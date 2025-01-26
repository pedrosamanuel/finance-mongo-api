package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "income")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income extends BaseDocument<String> {
    private float amount;
    private Date date;
    private String description;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

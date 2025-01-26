package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "savingTarget")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavingTarget extends BaseDocument<String> {
    private String description;
    private float amount;
    private Date deadlineDate;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

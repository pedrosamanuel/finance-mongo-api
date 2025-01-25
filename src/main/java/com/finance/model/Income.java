package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "income")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income extends BaseDocument<String> {
    private float amount;
    private String description;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

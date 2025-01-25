package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseDocument<String>{
    private String name;
    private String userId;
    @Builder.Default
    private boolean isActive = true;
}

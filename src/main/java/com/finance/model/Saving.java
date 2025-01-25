package com.finance.model;

import com.finance.generic.BaseDocument;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "saving")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Saving extends BaseDocument<String> {
    private float amount;
    private LocalDate date;
    private String savingTargetId;
}

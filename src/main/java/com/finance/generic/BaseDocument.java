package com.finance.generic;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class BaseDocument<ID>{
    @Id
    private ID id;
}

package com.finance.payload.response;

import com.finance.generic.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryResponse extends BaseResponse<String> {
    private String name;
}

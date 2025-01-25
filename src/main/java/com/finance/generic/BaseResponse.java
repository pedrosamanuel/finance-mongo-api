package com.finance.generic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse<T> {

    private T id;

    public BaseResponse() {
    }

    public BaseResponse(T id) {
        this.id = id;
    }
}

package com.onlinestore.payload;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private T data;

    public BaseResponse () {}

    public BaseResponse (T data) {
        this.data = data;
    }
}

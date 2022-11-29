package com.hello.springboothello.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponseResult<T> {
    private long timestamp;
    private String status;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T>  ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getDescription())
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder()
                .data(data)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .status(ResponseStatus.FAIL.getResponseCode())
                .build();
    }

    public static <T> ResponseResult<T> buildResult(T data, ResponseStatus responseStatus) {
        return ResponseResult.<T>builder()
                .data(data)
                .message(responseStatus.getDescription())
                .timestamp(System.currentTimeMillis())
                .status(responseStatus.getResponseCode())
                .build();
    }
}

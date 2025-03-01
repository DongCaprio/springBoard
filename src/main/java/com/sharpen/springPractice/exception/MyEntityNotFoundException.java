package com.sharpen.springPractice.exception;

import lombok.Getter;

@Getter
public class MyEntityNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    private MyEntityNotFoundException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public static MyEntityNotFoundException getInstance() {
        return new MyEntityNotFoundException(
                ErrorCode.ENTITY_NOT_FOUND
        );
    }
}

package com.sharpen.springPractice.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;

    @Builder
    public ErrorResponse(String errorCode, String message, LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }
}

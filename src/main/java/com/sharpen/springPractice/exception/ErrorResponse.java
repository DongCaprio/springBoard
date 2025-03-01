package com.sharpen.springPractice.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
class ErrorResponse {
    private int statusCode;
    private LocalDateTime timestamp;
    private String code;
    private String message;
    private String myMessage;

    @Builder
    public ErrorResponse(int statusCode, LocalDateTime timestamp, String code, String message, String myMessage) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.myMessage = myMessage;
    }

    public static ErrorResponse of(ErrorCode errorCode, String defaultMessage) {
        return builder()
                .statusCode(errorCode.getHttpStatus().value())
                .timestamp(LocalDateTime.now())
                .code(errorCode.getCode())
                .message(defaultMessage)
                .myMessage(errorCode.getMessage())
                .build();
    }
}

package com.yasas.hotel.exception.handler;

import com.yasas.hotel.exception.RoomIsNotFoundException;
import com.yasas.hotel.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomIsNotFoundException.class)
    public ResponseEntity<ErrorResponse> roomIsNotFound(RoomIsNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build()
        );

    }
}

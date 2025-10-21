package com.yasas.hotel.exception.handler;

import com.yasas.hotel.exception.ClientAlreadyExistException;
import com.yasas.hotel.exception.PhoneNumberIsWrongException;
import com.yasas.hotel.exception.RoomIsNotFoundException;
import com.yasas.hotel.exception.StaffMemberDoesNotExistException;
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

    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> clientAlreadyExist(ClientAlreadyExistException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message(ex.getMessage())
                        .build()
        );
    }
    @ExceptionHandler(PhoneNumberIsWrongException.class)
    public ResponseEntity<ErrorResponse>wrongPhoneNumber(PhoneNumberIsWrongException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message(ex.getMessage())
                        .build()
        );

    }
    @ExceptionHandler(StaffMemberDoesNotExistException.class)
    public ResponseEntity<ErrorResponse>memberDoesNotExist(StaffMemberDoesNotExistException ex){

        return ResponseEntity.badRequest().body(
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

}

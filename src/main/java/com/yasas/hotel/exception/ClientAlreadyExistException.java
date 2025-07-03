package com.yasas.hotel.exception;

public class ClientAlreadyExistException extends RuntimeException {

    public ClientAlreadyExistException(String message){
        super(message);
    }
}

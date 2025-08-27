package com.yasas.hotel.exception;

public class PhoneNumberIsWrongException extends RuntimeException{

    public PhoneNumberIsWrongException(String message){
        super(message);
    }
}

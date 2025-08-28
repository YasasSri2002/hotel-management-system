package com.yasas.hotel.exception;

public class StaffMemberDoesNotExistException extends RuntimeException {
    public StaffMemberDoesNotExistException(String message) {
        super(message);
    }
}

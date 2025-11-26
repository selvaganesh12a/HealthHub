package com.healthhub.backend.exception;

public class AppointmentConflictException extends RuntimeException {
    public AppointmentConflictException(String message) {
        super(message);
    }
}

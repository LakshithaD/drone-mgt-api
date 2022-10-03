package com.musalasoft.drone.mgt.api.excetions;

public class ValidationException extends RuntimeException{

    private String field;

    public ValidationException(String field) {
        super(String.format("Duplicate value for the field {}", field));
        this.field = field;
    }
}

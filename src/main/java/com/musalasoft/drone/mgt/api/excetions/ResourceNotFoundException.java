package com.musalasoft.drone.mgt.api.excetions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    private String resource;

    public ResourceNotFoundException(String message, String resource) {
        super(message);
        this.resource = resource;
    }
}

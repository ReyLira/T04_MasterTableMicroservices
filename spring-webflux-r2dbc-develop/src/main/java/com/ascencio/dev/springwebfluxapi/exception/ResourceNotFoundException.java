package com.ascencio.dev.springwebfluxapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Resource Not Found Exception";

    public ResourceNotFoundException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}

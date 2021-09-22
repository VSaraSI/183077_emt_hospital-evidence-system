package com.example.shared_kernel.domain.exceptions;

public class IdMustNotBeNull extends RuntimeException{

    public IdMustNotBeNull(String message) {
        super(message);
    }
}

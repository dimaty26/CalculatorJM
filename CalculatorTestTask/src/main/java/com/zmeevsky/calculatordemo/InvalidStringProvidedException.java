package com.zmeevsky.calculatordemo;

public class InvalidStringProvidedException extends RuntimeException {

    public InvalidStringProvidedException(String message) {
        super(message);
    }
}

package com.trilogyed.stwitter.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
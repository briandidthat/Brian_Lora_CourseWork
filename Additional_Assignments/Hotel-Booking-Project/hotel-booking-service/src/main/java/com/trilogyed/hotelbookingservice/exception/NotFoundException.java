package com.trilogyed.hotelbookingservice.exception;

/*Task:
 *
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}

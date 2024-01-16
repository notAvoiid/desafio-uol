package com.imrzoom.desafiouol.exceptions;

public class NoSuchElementException extends RuntimeException{

    public NoSuchElementException() {
        super("Element exceeded the limit");
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}

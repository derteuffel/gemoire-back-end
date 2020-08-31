package com.Gemoire.Gemoire.exceptions;

public class MemoireNotFoundException extends RuntimeException{
    public MemoireNotFoundException(String message) {
        super(message);
    }
}

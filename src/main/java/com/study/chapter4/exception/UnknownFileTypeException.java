package com.study.chapter4.exception;

public class UnknownFileTypeException extends RuntimeException{
    public UnknownFileTypeException(final String message){
        super(message);
    }
}

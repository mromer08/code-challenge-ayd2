package com.ayd2.spring_challenge.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}
    
    public NotFoundException(String message){
        super(message);
    }
}

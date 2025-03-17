package com.ayd2.spring_challenge.exceptions;

public class ServiceException extends Exception{
    public ServiceException(){}
    
    public ServiceException(String message){
        super(message);
    }
}

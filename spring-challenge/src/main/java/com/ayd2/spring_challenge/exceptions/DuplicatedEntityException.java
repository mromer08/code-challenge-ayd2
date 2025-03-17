package com.ayd2.spring_challenge.exceptions;

// Avisarle al desarrollador sober el error
// en la capa de business layer, es mejor usar excepciones del tipo cheked
// para que el desarrollador sepa que debe manejarlas
public class DuplicatedEntityException extends Exception{
    public DuplicatedEntityException(){}
    
    public DuplicatedEntityException(String message){
        super(message);
    }
}

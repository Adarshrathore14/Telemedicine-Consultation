package com.telemedicine.registration.exceptions;

public class DeserializationException extends RuntimeException{
    public DeserializationException(String message){
        super(message);
    }
}

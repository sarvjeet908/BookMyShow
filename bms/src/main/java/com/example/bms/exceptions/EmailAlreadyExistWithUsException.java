package com.example.bms.exceptions;

public class EmailAlreadyExistWithUsException extends Exception {
    public EmailAlreadyExistWithUsException(){
        super("email id is registered with us.");
    }
}

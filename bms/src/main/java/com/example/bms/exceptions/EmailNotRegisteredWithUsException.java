package com.example.bms.exceptions;

public class EmailNotRegisteredWithUsException extends Exception {
    public EmailNotRegisteredWithUsException(){
        super("Email not registered first register with us by signup.");
    }
}

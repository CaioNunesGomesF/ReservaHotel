package model.exceptions;

import application.Program;

import java.io.Serial;

public class DomainException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }
}

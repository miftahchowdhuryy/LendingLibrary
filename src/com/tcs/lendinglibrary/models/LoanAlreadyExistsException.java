package com.tcs.lendinglibrary.models;

public class LoanAlreadyExistsException extends Exception{
    public LoanAlreadyExistsException(String s){
        super(s);

    }
}

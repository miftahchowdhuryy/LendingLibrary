package com.tcs.lendinglibrary.models;

public class LoanNotFoundException extends Exception{
    public LoanNotFoundException(String s) {
        super(s);
    }
}

package com.tcs.lendinglibrary.models;

import com.tcs.lendinglibrary.utilities.LoanStatus;

import java.util.ArrayList;
import java.util.List;

public class LoanRegistry {
    private static List<Loan> registry = new ArrayList<>();

    public static void addLoan(Loan loan) throws LoanAlreadyExistsException {
        if (registry.contains(loan) && loan.getStatus() == LoanStatus.CURRENT) {
            throw new LoanAlreadyExistsException("Loan Already Exist!");
        }
        registry.add(loan);
    }

    public static Loan findLoan(Loan loan) throws LoanNotFoundException{
        if(registry.contains(loan)){
            return loan;
        }
        throw new LoanNotFoundException("Loan Not Found!");
    }

    public static List<Loan> getRegistry() {
        return registry;
    }



}

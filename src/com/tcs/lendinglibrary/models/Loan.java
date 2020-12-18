package com.tcs.lendinglibrary.models;

import com.tcs.lendinglibrary.utilities.LoanStatus;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Loan {
    private int loanID;
    private Customer customer;
    private Book book;
    private Date startDate;
    private Date dueDate;
    private static Date returnDate;
    private static LoanStatus status;

    public Loan(int loanID, Customer customer, Book book) {
        this.loanID = loanID;
        this.customer = customer;
        this.book = book;

        GregorianCalendar gCal = new GregorianCalendar();
        startDate = gCal.getTime();
        gCal.add(GregorianCalendar.WEEK_OF_MONTH, 2);
        dueDate = gCal.getTime();
        status = LoanStatus.CURRENT;
    }

    public static void endLoan(){
        returnDate = new Date();
        status = LoanStatus.HISTORIC;

    }

    public int getLoanID() {
        return loanID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LoanID: " + loanID + "\nCustomer Name: " +
                customer.getMailingName() +
                "\nBook Title: " + book.getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanID == loan.loanID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanID);
    }
}

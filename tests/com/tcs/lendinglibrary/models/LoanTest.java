package com.tcs.lendinglibrary.models;

import com.tcs.lendinglibrary.utilities.GenderType;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;
public class LoanTest {

    @Test
    public void testDueDate(){
       Book book = new Book("0", " ", " ", " ", " ", 0);
       Customer customer = new Customer(0, " ", " ", " ", " ", " ", " ", GenderType.FEMALE);
       Loan loan = new Loan(0, customer, book);

        GregorianCalendar gcExpected = new GregorianCalendar();
        gcExpected.add(GregorianCalendar.WEEK_OF_MONTH, 2);

        GregorianCalendar gcActual = new GregorianCalendar();
        gcActual.setTime(loan.getDueDate());

        /*
        * assertEquals(expectedValue, actualValue)
        * If actualValue equals expected value, the method does nothing.
        * If not the method causes jUnit to fail the test method.
        * It throws an AssertionFailureException
        *
        * */

        assertEquals("Checking Year: ", gcExpected.get(GregorianCalendar.YEAR), gcActual.get(GregorianCalendar.YEAR));
        assertEquals("Checking Month: ", gcExpected.get(GregorianCalendar.MONTH), gcActual.get(GregorianCalendar.MONTH));
        assertEquals("Checking Day: ", gcExpected.get(GregorianCalendar.DAY_OF_MONTH), gcActual.get(GregorianCalendar.DAY_OF_MONTH));
    }

}
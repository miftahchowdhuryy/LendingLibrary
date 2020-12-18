package com.tcs.lendinglibrary.models;

import com.tcs.lendinglibrary.utilities.GenderType;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRecordsTest {
    Customer newCustomer;
    int initialSize;

    public CustomerRecordsTest() {
        initialSize = CustomerRecords.getNumberOfCustomer();
        newCustomer = new Customer(5, "Miss", "Muntaha", "Rahman", " ", " ", " ", GenderType.MALE);
        try {
            CustomerRecords.addCustomer(newCustomer);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testAddCustomer(){

        assertTrue(initialSize == CustomerRecords.getNumberOfCustomer() - 1);

    }

    @Test
    public void testFindCustomer(){
        try {
            Customer foundCustomer = CustomerRecords.findByName("Miss M Rahman");
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            fail("Customer not found!");
        }

    }

    @Test
    public void testNoDuplicate(){
        Customer newCustomer = new Customer(5, "Miss", "Muntaha", "Rahman", " ", " ", " ", GenderType.MALE);
        try {
            CustomerRecords.addCustomer(newCustomer);
            CustomerRecords.addCustomer(newCustomer);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
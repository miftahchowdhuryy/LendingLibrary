package com.tcs.lendinglibrary.models;

import java.util.HashSet;
import java.util.Set;

public class CustomerRecords {
   private static Set<Customer> customerRecords = new HashSet<>();

    public static void addCustomer(Customer customer)throws CustomerAlreadyExistsException{
        if(customerRecords.contains(customer)){
            throw new CustomerAlreadyExistsException("Sorry! Customer Already Exist! ");
        }
        else {
            customerRecords.add(customer);
        }
    }

    public static Customer findByName (String customerName) throws CustomerNotFoundException{
        for(Customer customer : customerRecords){
            if(customer.getMailingName().equals(customerName)){
                return customer;
            }
        }
        throw new CustomerNotFoundException("Sorry! Customer has not found");
    }

    public static Set<Customer> getCustomerRecord(){
        return customerRecords;
    }

    public static int getNumberOfCustomer(){
        return customerRecords.size();
    }



}

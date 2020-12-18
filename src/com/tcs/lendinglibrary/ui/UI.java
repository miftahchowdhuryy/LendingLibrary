package com.tcs.lendinglibrary.ui;

import com.tcs.lendinglibrary.models.Book;
import com.tcs.lendinglibrary.models.Customer;
import com.tcs.lendinglibrary.models.Material;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UI {
    public static void printBookHeader(){
        System.out.println("BookID  Title                 Author");
    }

    public static void printMaterial(Material book){
        System.out.println(fixLengthString(book.getId(), 6) + "  " + fixLengthString(book.getTitle(), 20) +
                "  " + fixLengthString(book.getAuthor(), 20));
    }

    public static void printCustomerHeader(){
        System.out.println("CustomerID  FirstName                      Surname                      Address                      " +
                "PhoneNumber                      " + "Email                                    Gender                      " +
                "IsCustomerValid                      ");
    }

    public static void printCustomer(Customer customer){
        System.out.println(
                        fixLengthString(customer.getUUID(),10) +"  "+
                        fixLengthString(customer.getFirstName(), 29) + "  " +
                        fixLengthString(customer.getSurname(), 27) + "  " +
                        fixLengthString(customer.getAddress(), 27) +"  "+
                        fixLengthString(customer.getPhoneNumber(),31) +"  "+
                        fixLengthString(customer.getEmail(), 39) +"  "+
                        customer.getGender() +"                        " +
                        customer.isValid());
    }

    // TODO: fix string padding problem
    private static String fixLengthString(String start, int length){
        if(start.length() >= length){
            return start.substring(0, length);
        }
        else {
            while(start.length() < length){
                start += " ";
            }
            return start;
        }

    }
    // overloaded method with a same return type and function name but different parameter
    private static String fixLengthString(int start, int length){
        // converting int to a string using this method
       String startString = String.valueOf(start);
       return fixLengthString(startString, length);

    }

    public static void printMaterialCatalog(Map<String, Material> materialCatalog){
        printBookHeader();

        for( Material nextMaterial : materialCatalog.values()){
            printMaterial(nextMaterial);
        }
    }

    public static void printCustomerRecord(Set<Customer> customerRecord){
        printCustomerHeader();
        for(Customer customer : customerRecord){
            printCustomer(customer);
        }
    }

}

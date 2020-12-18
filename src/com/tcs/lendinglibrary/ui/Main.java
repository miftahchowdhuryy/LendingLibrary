package com.tcs.lendinglibrary.ui;

import com.tcs.lendinglibrary.models.*;
import com.tcs.lendinglibrary.utilities.GenderType;

    /*
    package name by convention - domain name for your company but set in reverse, add onto that,
    your application name and then your package name
    */

public class Main {
    public static MaterialCatalogInterface materialCatalog;
    public static void main(String[] args) {

        Customer cs1 = new Customer(1, "Mr", "Miftah", "Chowdhury", "Jamaica, NY",
                "347-592-8780", "miftahchowdhury@outlook.com", GenderType.MALE);


        Customer cs2 = new Customer(2, "Miss", "Sanjida", "Islam", "Kew Gardens, NY",
                "646-623-6074", "sanjidislam@gmail.com", GenderType.FEMALE);

        try {
            CustomerRecords.addCustomer(cs1);
            CustomerRecords.addCustomer(cs2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        UI.printCustomerRecord(CustomerRecords.getCustomerRecord());


        System.out.println("------------------------------------------------------------------------------");

        Book book1 = new Book("1", "An Introduction to Java", "Matt Greencroft", "12345", "Jamaica", 100);
        Book book2 = new Book("2", "Better Java", "Joe Le Blanc", "12245", "Kew Gardens", 120);


        DVD dvd1 = new DVD("1", "An Epic Film About Java", "Jamaica", "Stephen Spielberg", "99887", 120);
        DVD dvd2 = new DVD("1", "An Epic Film About Java", "Jamaica", "Stephen Spielberg", "99887", 120);

        materialCatalog = new MaterialCatalogDatabaseVersion();

/*        materialCatalog.addMaterial(book1);
        materialCatalog.addMaterial(book2);
        materialCatalog.addMaterial(dvd1);
        materialCatalog.addMaterial(dvd2);*/

        System.out.println("There are " + materialCatalog.getNumberOfMaterials() + " items in the library");
        try {
            Material foundMaterial = materialCatalog.findMaterial("Java");
            System.out.println("Found Material: " + foundMaterial.getTitle());
        } catch (MaterialNotFoundException e) {
            System.out.println(e.getMessage());
        }

        UI.printMaterialCatalog(materialCatalog.getMaterialMap());

        /*try {
            Material foundBook = materialCatalog.findMaterial("Better");
            UI.printMaterial(foundBook);
        }
        catch (MaterialNotFoundException e){
            System.out.println("The book was not found");
        }


        System.out.println(cs1.dateFormat);
        System.out.println(cs2.getMailingName());

        System.out.println(dvd1.lend(cs1));
        dvd1.licence();
        System.out.println(dvd1.lend(cs1));
        System.out.println(dvd1.lend(cs1));
        System.out.println(book1.lend(cs1));
        System.out.println(book1.lend(cs1));

        System.out.println(book1.getLoanPeriod());
        System.out.println(dvd1.getLoanPeriod());

        System.out.println(cs1.toString());
        System.out.println(dvd1.hashCode());

        System.out.println(dvd1);

        System.out.println(book1.equals(book2));

        Loan loan1 = new Loan(1, cs1, book1);
        Loan loan2 = new Loan(2, cs2, book2);
        Loan loan3 = new Loan(3, cs1, book1);
        Loan loan4 = new Loan(4, cs2, book2);


        System.out.println("Loan Start Date: " + loan1.getStartDate());
        System.out.println("Loan Due Date: " + loan1.getDueDate());
        System.out.println(loan1);
        System.out.println(loan2);

        Loan.endLoan();
        System.out.println(loan1.getReturnDate());

        System.out.println("_________________________________________");

        try {
            LoanRegistry.addLoan(loan1);
            LoanRegistry.addLoan(loan1);
        } catch(LoanAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------------");

        try {
            Loan foundLoan = LoanRegistry.findLoan(loan4);
            System.out.println("Found Loan: \n" + foundLoan);
        } catch (LoanNotFoundException e){
            System.out.println(e.getMessage());
        }


    }*/
    }


}


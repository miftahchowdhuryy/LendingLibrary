package com.tcs.lendinglibrary.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookCatalogTest {
    private Book book;
    public MaterialCatalogMemoryVersion materialCatalog;

    public BookCatalogTest() {
        materialCatalog = new MaterialCatalogMemoryVersion();
        this.book = new Book("1", "Learning Java", " ", " ", " ", 0);
        materialCatalog.addMaterial(book);
        System.out.println("Constructor being run!");
    }

    @Test
    public void testAddABook(){
        int initialNumber = materialCatalog.getNumberOfMaterials();

        Book book = new Book("2", " ", " ", " ", " ", 0);
        materialCatalog.addMaterial(book);
        int currentNumber = materialCatalog.getNumberOfMaterials();

        assertTrue(initialNumber == (currentNumber) - 1);
    }

    @Test (expected = MaterialNotFoundException.class)
    public void testFindABook() throws MaterialNotFoundException {
        Material foundBook = materialCatalog.findMaterial("Learning not Java");
    }

    @Test
    public void testFindABookIgnoringCase(){
        try {
            Material foundBook = materialCatalog.findMaterial("learning java");
            assertEquals(book.getTitle(), foundBook.getTitle());
        } catch (MaterialNotFoundException e){
            fail("Book not Found!");
        }
    }

    @Test
    public void testFindABookWithExtraSpace(){
        try {
            Material foundBook = materialCatalog.findMaterial("   learning java  ");
        } catch (MaterialNotFoundException e) {
            fail("Book not Found!");
        }
    }
}
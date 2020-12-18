package com.tcs.lendinglibrary.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void test2BooksEqual(){
        Book book1 = new Book("1", " ", " ", " ", " ", 0);
        Book book2 = new Book("1", " ", " ", " ", " ", 0);

        assertTrue(book1.equals(book2)); // true
    }

    @Test
    public void test2NonEqualBooks(){
        Book book1 = new Book("1", " ", " ", " ", " ", 0);
        Book book2 = new Book("2", " ", " ", " ", " ", 0);

        assertFalse("They are not equals: ", book1.equals(book2)); // false
    }

}
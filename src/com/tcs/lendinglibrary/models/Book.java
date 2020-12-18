package com.tcs.lendinglibrary.models;

public class Book extends Material {
    private String author;
    private String ISBN;

    private int noOfPages;


    public Book(String id, String title, String author, String ISBN, String branch, int noOfPages) {
        // calling my parent class constructor
        super(id, title, branch);
        this.author = author;
        this.ISBN = ISBN;
        this.noOfPages = noOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "models.Book{" +
                "bookID=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public void sendForRepair(){
        System.out.println("Book Repair");
    }

    @Override
    public int getLoanPeriod() {
        return 21;
    }

    public int getNoOfPages() {
        return noOfPages;
    }
}

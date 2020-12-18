package com.tcs.lendinglibrary.models;

public abstract class Material {
    private String id;
    private String title;
    private String branch;
    private Customer borrower;


    public Material(String id, String title, String branch) {
        this.id = id;
        this.title = title;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBranch() {
        return branch;
    }

    public void relocate(String newBranch){
        this.branch = newBranch;
    }

    public boolean lend(Customer customer){
        if(borrower == null){
            borrower = customer;
            return true;
        }
        return false;
    }

    public abstract int getLoanPeriod();

    @Override
    public String toString() {
        return id + " : " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(this.getClass() != (obj.getClass()))
            return false;
        Material otherClass = (Material) obj;

        if(this.id != otherClass.id)
            return false;

        return true;
    }

    public String getAuthor() {
        return null;
    }
}

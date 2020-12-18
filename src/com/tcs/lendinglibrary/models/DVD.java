package com.tcs.lendinglibrary.models;

public class DVD extends Material{
    private String director;
    private String catalogNo;
    private int runningTime;
    private boolean isLicenced;

    public DVD(String id, String title, String branch, String director, String catalogNo, int runningTime) {
        super(id, title, branch);
        this.director = director;
        this.catalogNo = catalogNo;
        this.runningTime = runningTime;
        isLicenced = false;
    }

    public void licence(){
        isLicenced = true;
    }

    public boolean lend(Customer customer){
        if(isLicenced){
            return super.lend(customer);
        }
        return false;
    }

    @Override
    public int getLoanPeriod() {
        return 7;
    }

    public String getDirector() {
        return director;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public boolean isLicenced() {
        return isLicenced;
    }
}
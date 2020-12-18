package com.tcs.lendinglibrary.models;
import com.tcs.lendinglibrary.utilities.GenderType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Customer {
    private int UUID;
    private String title;
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private GenderType gender;
    private boolean isValid;
    private Date expiryDate;
    public String dateFormat;

    public Customer(int UUID, String title, String firstName, String surname, String address, String phoneNumber, String email, GenderType gender) {
        this.UUID = UUID;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.isValid = true;

        GregorianCalendar gCal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        gCal.add(GregorianCalendar.YEAR, 1);
        expiryDate = gCal.getTime();
        dateFormat = sdf.format(expiryDate);
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getUUID() {
        return UUID;
    }

    public GenderType getGender() {
        return gender;
    }

    public boolean isValid() {
        return isValid;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getMailingName(){
      /*  String mailingName;
        mailingName = title + " " + firstName.substring(0,1) + " " + surname;
        return  mailingName;*/

        StringBuilder mailingName = new StringBuilder(title);
        mailingName.append(" ");
        mailingName.append(firstName.substring(0,1));
        mailingName.append(" ");
        mailingName.append(surname);

        return mailingName.toString();
    }

    @Override
    public String toString() {
        return getMailingName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return UUID == customer.UUID && isValid == customer.isValid && Objects.equals(title, customer.title) && Objects.equals(firstName, customer.firstName) && Objects.equals(surname, customer.surname) && Objects.equals(address, customer.address) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email) && gender == customer.gender && Objects.equals(expiryDate, customer.expiryDate) && Objects.equals(dateFormat, customer.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID, title, firstName, surname, address, phoneNumber, email, gender, isValid, expiryDate, dateFormat);
    }
}
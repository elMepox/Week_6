package com.sergey.kataev;

public class User {
    private String phoneNumber;
    private String surname;
    private int year;

    public User(String phoneNumber, String surname, int year) {
        this.phoneNumber = phoneNumber;
        this.surname = surname;
        this.year = year;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.surname).append(',').append(this.year).append(',').append(this.phoneNumber);
        return builder.toString();
    }
}

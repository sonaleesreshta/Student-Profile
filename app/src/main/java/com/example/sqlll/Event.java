package com.example.sqlll;

public class Event {
    private String nName;
    private String nYear;
    private String nEmail;
    private String nNumber;
    //private String nContent;

    public Event(String name, String year, String email, String number) {
        nName = name;
        nYear = year;
        nEmail = email;
        nNumber = number;
        //nContent = content;
    }

    public String getName() {
        return nName;
    }

    public String getYear() {
        return nYear;
    }

    public String getEmail() {
        return nEmail;
    }

    public String getNumber() {
        return nNumber;
    }

    //public String getContent() {
      //  return nContent;
    //}
}
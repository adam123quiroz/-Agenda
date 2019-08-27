package com.company;

public class Contact {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private int number;

    public Contact(String id, String name, String surname, String email, String adress, int number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = adress;
        this.number = number;
    }

    public Contact( ) {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.email = null;
        this.address = null;
        this.number = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

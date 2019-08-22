package com.company;

public class Contacto {

    private String id;
    private String name;
    private String apellido;
    private String email;
    private String adress;
    private int number;

    public Contacto(String id, String name, String apellido, String email, String adress, int number) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.adress = adress;
        this.number = number;
    }

    public Contacto( ) {
        this.id = null;
        this.name = null;
        this.apellido = null;
        this.email = null;
        this.adress = null;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

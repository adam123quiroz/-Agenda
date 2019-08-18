package com.company;

import org.jetbrains.annotations.Contract;

public class Contacto {
    private String name;
    private String apellido;
    private String email;
    private String adress;
    private int number;

    @Contract(pure = true)
    public Contacto(String name, String apellido, String email, String adress, int number) {
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.adress = adress;
        this.number = number;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.POJO;

/**
 *
 * @author g170959
 */
public class Client {
    private int id;
    private String name;
    private String address;
    private String number;
    private long cep;
    private String email;

    public Client(String name, String address, String number, long cep, String email) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.cep = cep;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.address + ", " + this.number + ", " + this.cep + ", " + this.email + " \n";
    }
}

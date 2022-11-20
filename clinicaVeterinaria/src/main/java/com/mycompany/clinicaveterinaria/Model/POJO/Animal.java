/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.POJO;

/**
 *
 * @author g170959
 */
public class Animal {
    private int id;
    private int clientId;
    private int speciesId;

    private String name;
    private String genre;

    public Animal(int String, String name, String genre, int clientId, int speciesId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.clientId = clientId;
        this.speciesId = speciesId;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }
    
    public int getSpeciesId() {
        return speciesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.genre + ", " + this.clientId + " \n";
    }
}

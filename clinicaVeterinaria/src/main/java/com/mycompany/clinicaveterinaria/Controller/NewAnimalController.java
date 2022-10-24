/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.AnimalDAO;

/**
 *
 * @author Guizera
 */
public class NewAnimalController {
    
    private AnimalDAO db = new AnimalDAO();
    
    public void insert(String name, String genre, String speciesId, String clientId) {
        this.db.insertNewAnimal(name, genre, speciesId, clientId);
    }
}

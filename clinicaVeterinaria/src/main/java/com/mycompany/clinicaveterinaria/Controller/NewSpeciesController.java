/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.SpeciesDAO;

/**
 *
 * @author Guizera
 */
public class NewSpeciesController {
    
    private SpeciesDAO db = new SpeciesDAO();
    
    public void insert(String name) {
        this.db.insertNewSpecies(name);
    }
}

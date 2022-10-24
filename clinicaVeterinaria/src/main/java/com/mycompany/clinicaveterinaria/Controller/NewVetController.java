/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.VeterinaryDAO;

/**
 *
 * @author Guizera
 */
public class NewVetController {
    
    private VeterinaryDAO db = new VeterinaryDAO();
    
    public void insert(String name, String address, String number) {
        this.db.insertNewVeterinary(name, address, number);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;

/**
 *
 * @author Guizera
 */
public class NewClientController {
    
    private ClientDAO db = new ClientDAO();
    
    public void insert(String name, String address, String number, int cep, String email) {
        this.db.insertNewClient(name, address, number, cep, email);
    }
}

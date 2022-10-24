/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.TreatmentDAO;

/**
 *
 * @author Guizera
 */
public class NewTreatmentController {
    
    private TreatmentDAO db = new TreatmentDAO();
    
    public void insert(String initDate, String finishDate, int animalId) {
        this.db.insertNewTreatment(initDate, finishDate, animalId);
    }
}

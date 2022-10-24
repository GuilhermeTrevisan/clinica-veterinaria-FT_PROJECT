/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;

/**
 *
 * @author Guizera
 */
public class NewAppointController {
    
    private MedicalAppointmentDAO db = new MedicalAppointmentDAO();
    
    public void insert(String date, String historic, int animalId, int vetId, int treatmentId) {
        this.db.insertNewAppointment(date, historic, animalId, vetId, treatmentId);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;
import javax.swing.table.AbstractTableModel;
import TableModel.AppointmentTableModel;
import TableModel.EmptyTableModel;

/**
 *
 * @author Guizera
 */
public class MainController {
    
    public AbstractTableModel getTableModelOf(String tableModel) {
        if(tableModel.equals("appointment")) {
            MedicalAppointmentDAO appointDB = new MedicalAppointmentDAO();
            return new AppointmentTableModel(appointDB.getAllAppointments(), new String[]{"date", "historic", "id_animal", "id_vet", "id_tratamento"});
        } else {
            return new EmptyTableModel();
        }
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;
import javax.swing.table.AbstractTableModel;
import TableModel.AppointmentTableModel;
import TableModel.ClientTableModel;
import TableModel.AnimalTableModel;
import TableModel.EmptyTableModel;
import com.mycompany.clinicaveterinaria.Model.DAO.AnimalDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;

/**
 *
 * @author Guizera
 */
public class MainController {
    
    // possivel melhoria: receber um enum ao inves de uma string
    public AbstractTableModel getTableModelOf(String tableModel) {
        if(tableModel.equals("appointment")) {
            MedicalAppointmentDAO appointDB = new MedicalAppointmentDAO();
            String[] columns = {"date", "historic", "id_animal", "id_vet", "id_tratamento"};
            return new AppointmentTableModel(appointDB.getAllAppointments(), columns);
            
        } else if(tableModel.equals("client")) {
            ClientDAO clientDB = new ClientDAO();
            String[] columns = {"name", "address", "cep", "email", "number"};
            return new ClientTableModel(clientDB.getAllUsers(), columns);
            
            // todos os radio buttons tão podendo ser selecionados ao mesmo tempo, tem q dar um jeito de deixar só 1
        } else if(tableModel.equals("animal")) {
            AnimalDAO animalDB = new AnimalDAO();
            String[] columns = {"name", "genre", "species_id", "client_id"};
            return new AnimalTableModel(animalDB.getAllAnimals(), columns);
            
            // todos os radio buttons tão podendo ser selecionados ao mesmo tempo, tem q dar um jeito de deixar só 1
        } else {
            return new EmptyTableModel();
        }
    } 
}

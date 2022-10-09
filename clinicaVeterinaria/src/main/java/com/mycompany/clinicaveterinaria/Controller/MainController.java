/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;
import javax.swing.table.AbstractTableModel;
import TableModel.AppointmentTableModel;
import TableModel.EmptyTableModel;
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
            String[] appointColumns = {"date", "historic", "id_animal", "id_vet", "id_tratamento"};
            return new AppointmentTableModel(appointDB.getAllAppointments(), appointColumns);
            
        } else if(tableModel.equals("client")) {
            
            ClientDAO clientDB = new ClientDAO();
            // colocar as colunas da tabela cliente aqui: String[] appointColumns = {"date", "historic", "id_animal", "id_vet", "id_tratamento"};
            
            // Criar o TableModel de cliente e depois do resto das coisas
            return new AppointmentTableModel(clientDB.getAllUsers(), appointColumns);
            
            // todos os radio buttons tão podendo ser selecionados ao mesmo tempo, tem q dar um jeito de deixar só 1
        } else {
            return new EmptyTableModel();
        }
    } 
}

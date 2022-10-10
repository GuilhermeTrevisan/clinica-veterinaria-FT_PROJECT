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
import TableModel.ExamTableModel;
import TableModel.SpeciesTableModel;
import TableModel.TreatmentTableModel;
import TableModel.VeterinaryTableModel;
import com.mycompany.clinicaveterinaria.Model.DAO.AnimalDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.ExamDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.SpeciesDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.TreatmentDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.VeterinaryDAO;
import view.NewAnimalWindow;
import view.NewAppointWindow;
import view.NewClientWindow;
import view.NewExamWindow;
import view.NewSpeciesWindow;
import view.NewTreatmentWindow;
import view.NewVetWindow;

/**
 *
 * @author Guizera
 */
public class MainController {
    
    // possivel melhoria: receber um enum ao inves de uma string
    public AbstractTableModel getTableModelOf(String tableModel) {
        switch (tableModel) {
            case "appointment":
                MedicalAppointmentDAO appointDB = new MedicalAppointmentDAO();
                String[] appointColumns = {"date", "historic", "id_animal", "id_vet", "id_tratamento"};
                return new AppointmentTableModel(appointDB.getAllAppointments(), appointColumns);
                
            case "client":
                ClientDAO clientDB = new ClientDAO();
                String[] clientColumns = {"name", "address", "cep", "email", "number"};
                return new ClientTableModel(clientDB.getAllUsers(), clientColumns);
                
            case "animal":            
                AnimalDAO animalDB = new AnimalDAO();
                String[] animalColumns = {"name", "genre", "species_id", "client_id"};
                return new AnimalTableModel(animalDB.getAllAnimals(), animalColumns);

            case "veterinary":
                VeterinaryDAO vetDB = new VeterinaryDAO();
                String[] vetColumns = {"name", "genre", "species_id", "client_id"};
                return new VeterinaryTableModel(vetDB.getAllVeterinaries(), vetColumns);
                
            case "species":
                SpeciesDAO speciesDB = new SpeciesDAO();
                String[] speciesColumns = {"id", "name"};
                return new SpeciesTableModel(speciesDB.getAllSpecies(), speciesColumns);
                
            case "exam":
                ExamDAO examDB = new ExamDAO();
                String[] examColumns = {"description", "appointment_id"};
                return new ExamTableModel(examDB.getAllExams(), examColumns);
                
            case "treatment":
                TreatmentDAO treatmentDB = new TreatmentDAO();
                String[] treatmentColumns = {"id_animal", "initDate", "finishDate"};
                return new TreatmentTableModel(treatmentDB.getAllTreatments(), treatmentColumns);
                
            default:
                return new EmptyTableModel();
        }
    }
    
    public void openCreateViewFor(String section) {
        switch (section) {
            case "appointment":
                NewAppointWindow appointFrame = new NewAppointWindow();
                appointFrame.setVisible(true);
                break;
                
            case "client":
                NewClientWindow clientFrame = new NewClientWindow();
                clientFrame.setVisible(true);
                break;
                
            case "animal":         
                NewAnimalWindow animalFrame = new NewAnimalWindow();
                animalFrame.setVisible(true);
                break;

            case "veterinary":
                NewVetWindow vetFrame = new NewVetWindow();
                vetFrame.setVisible(true);
                break;
                
            case "species":
                NewSpeciesWindow speciesFrame = new NewSpeciesWindow();
                speciesFrame.setVisible(true);
                break;
                
            case "exam":
                NewExamWindow examFrame = new NewExamWindow();
                examFrame.setVisible(true);
                break;
                
            case "treatment":
                NewTreatmentWindow treatmentFrame = new NewTreatmentWindow();
                treatmentFrame.setVisible(true);
                break;
                
            default:
                // open screen
        }
    }
}

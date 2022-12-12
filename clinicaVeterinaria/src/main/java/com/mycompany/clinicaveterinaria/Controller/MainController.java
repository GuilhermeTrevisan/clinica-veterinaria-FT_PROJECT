/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;
import javax.swing.table.AbstractTableModel;
import com.mycompany.clinicaveterinaria.TableModel.AppointmentTableModel;
import com.mycompany.clinicaveterinaria.TableModel.ClientTableModel;
import com.mycompany.clinicaveterinaria.TableModel.AnimalTableModel;
import com.mycompany.clinicaveterinaria.TableModel.EmptyTableModel;
import com.mycompany.clinicaveterinaria.TableModel.ExamTableModel;
import com.mycompany.clinicaveterinaria.TableModel.SpeciesTableModel;
import com.mycompany.clinicaveterinaria.TableModel.TreatmentTableModel;
import com.mycompany.clinicaveterinaria.TableModel.VeterinaryTableModel;
import com.mycompany.clinicaveterinaria.Model.DAO.AnimalDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.ExamDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.SpeciesDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.TreatmentDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.VeterinaryDAO;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import view.NewAnimalWindow;
import view.NewAppointWindow;
import view.NewClientWindow;
import view.NewExamWindow;
import view.NewSpeciesWindow;
import view.NewTreatmentWindow;
import view.NewVetWindow;
import view.UpdateClientView;

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
                String[] appointColumns = {"id", "data", "histórico", "animal", "veterinário", "id do tratamento"};
                return new AppointmentTableModel(appointDB.getAllAppointments(), appointColumns);
                
            case "client":
                ClientDAO clientDB = new ClientDAO();
                String[] clientColumns = {"id", "nome", "endereço", "cep", "email", "telefone"};
                return new ClientTableModel(clientDB.getAllUsers(), clientColumns);
                
            case "animal":            
                AnimalDAO animalDB = new AnimalDAO();
                String[] animalColumns = {"id", "nome", "genero", "espécie", "id do cliente"};
                return new AnimalTableModel(animalDB.getAllAnimals(), animalColumns);

            case "veterinary":
                VeterinaryDAO vetDB = new VeterinaryDAO();
                String[] vetColumns = {"id", "nome", "endereço", "number"};
                return new VeterinaryTableModel(vetDB.getAllVeterinaries(), vetColumns);
                
            case "species":
                SpeciesDAO speciesDB = new SpeciesDAO();
                String[] speciesColumns = {"id", "nome"};
                return new SpeciesTableModel(speciesDB.getAllSpecies(), speciesColumns);
                
            case "exam":
                ExamDAO examDB = new ExamDAO();
                String[] examColumns = {"id", "descrição", "id da consulta"};
                return new ExamTableModel(examDB.getAllExams(), examColumns);
                
            case "treatment":
                TreatmentDAO treatmentDB = new TreatmentDAO();
                String[] treatmentColumns = {"id", "id do animal", "data de início", "data de fim"};
                return new TreatmentTableModel(treatmentDB.getAllTreatments(), treatmentColumns);
                
            default:
                return new EmptyTableModel();
        }
    }
    
    public void finishTreatment(int id, String initDate, int animalId) {
         TreatmentDAO treatmentDB = new TreatmentDAO();
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
         LocalDateTime now = LocalDateTime.now();  
         var finishDate = dtf.format(now);
         treatmentDB.updateTreatmentById(id, initDate, finishDate, animalId );
    }
    
    public AbstractTableModel getTableModelOf(int clientId) {
        AnimalDAO client_animalDB = new AnimalDAO();
        String[] client_animalColumns = {"nome", "genero", "id da espécie", "id do cliente"};
        return new AnimalTableModel(client_animalDB.getAnimalByClientId(clientId), client_animalColumns);
    }
    
    public void openCreateViewFor(String section, UpdateScreenInterface screenUpdater) {
        switch (section) {
            case "appointment":
                NewAppointWindow appointFrame = new NewAppointWindow(screenUpdater);
                appointFrame.setVisible(true);
                break;
                
            case "client":
                NewClientWindow clientFrame = new NewClientWindow(screenUpdater);
                clientFrame.setVisible(true);
                break;
                
            case "animal":         
                NewAnimalWindow animalFrame = new NewAnimalWindow(screenUpdater);
                animalFrame.setVisible(true);
                break;

            case "veterinary":
                NewVetWindow vetFrame = new NewVetWindow(screenUpdater);
                vetFrame.setVisible(true);
                break;
                
            case "species":
                NewSpeciesWindow speciesFrame = new NewSpeciesWindow(screenUpdater);
                speciesFrame.setVisible(true);
                break;
                
            case "exam":
                NewExamWindow examFrame = new NewExamWindow(screenUpdater);
                examFrame.setVisible(true);
                break;
                
            case "treatment":
                NewTreatmentWindow treatmentFrame = new NewTreatmentWindow(screenUpdater);
                treatmentFrame.setVisible(true);
                break;
                
            default:
                // open screen
        }
    }
    
    public void delete(String section, int id) {
        switch (section) {
            case "appointment":
                MedicalAppointmentDAO appointDB = new MedicalAppointmentDAO();
                appointDB.deleteAppointmentById(id);
                break;
                
            case "client":
                ClientDAO clientDB = new ClientDAO();
                AnimalDAO animal_clientDAO = new AnimalDAO();
                clientDB.deleteClientById(id);
                animal_clientDAO.deleteAnimalByClientId(id);
                break;
                
            case "animal":            
                AnimalDAO animalDB = new AnimalDAO();
                animalDB.deleteAnimalById(id);
                break;

            case "veterinary":
                VeterinaryDAO vetDB = new VeterinaryDAO();
                vetDB.deleteVeterinaryById(id);
                break;
                
            case "species":
                SpeciesDAO speciesDB = new SpeciesDAO();
                speciesDB.deleteSpeciesById(id);
                break;
                
            case "exam":
                ExamDAO examDB = new ExamDAO();
                examDB.deleteExamById(id);
                break;
                
            case "treatment":
                TreatmentDAO treatmentDB = new TreatmentDAO();
                treatmentDB.deleteTreatmentById(id);
                break;
                
            default:
                return;
        }
    }
    
    public AbstractTableModel search(String section, String text) throws ParseException {
        switch (section) {
            case "appointment":
                MedicalAppointmentDAO appointDB = new MedicalAppointmentDAO();
                String[] appointColumns = {"id", "data", "histórico", "id do animal", "id do veterinário", "id do tratamento"};
                return new AppointmentTableModel(appointDB.getAppointmentByDate(text), appointColumns);
                
            case "client":
                ClientDAO clientDB = new ClientDAO();
                String[] clientColumns = {"id", "nome", "endereço", "cep", "email", "telefone"};
                return new ClientTableModel(clientDB.getAllClientsByName(text), clientColumns);
                
            default:
                return new EmptyTableModel();
                
        }
    }
}

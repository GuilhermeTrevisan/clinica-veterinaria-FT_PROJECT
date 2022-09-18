/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clinicaveterinaria;

import com.mycompany.clinicaveterinaria.Model.DAO.MedicalAppointmentDAO;
import java.sql.Date;

/**
 *
 * @author g170959
 */
public class ClinicaVeterinaria {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //testar:
        // get all
        // get by id
        // insert new
        // update
        // delete
        
        // appoint
        // species
        // treatement
        // veterinary
        
        MedicalAppointmentDAO db = new MedicalAppointmentDAO();
        
        db.insertNewAppointment(new Date(2022, 2, 14), "primeira consulta", 2, 3, 1);
        
        //db.updateAppointmentById(1, date, "segunda consulta", 2, 3, 1);
        //db.deleteAppointmentById(1);
        
        System.out.println(db.getAppointmentById(1).toString());
        System.out.println(db.getAllAppointments().toString());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clinicaveterinaria;

import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;

/**
 *
 * @author g170959
 */
public class ClinicaVeterinaria {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ClientDAO clientDB = new ClientDAO();
       
         System.out.println(clientDB.getAllUsers().toString());
    }
}

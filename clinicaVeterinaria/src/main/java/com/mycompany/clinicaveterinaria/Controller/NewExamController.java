/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Controller;

import com.mycompany.clinicaveterinaria.Model.DAO.ExamDAO;

/**
 *
 * @author Guizera
 */
public class NewExamController {
    
    private ExamDAO db = new ExamDAO();
    
    public void insert(String description, int appoint) {
        this.db.insertNewExam(description, appoint);
    }
}

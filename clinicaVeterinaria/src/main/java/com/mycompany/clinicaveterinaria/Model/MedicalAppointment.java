/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model;
import java.util.Date;

/**
 *
 * @author g170959
 */
public class MedicalAppointment {
    private int id;
    private Date date;
    private String historic;

    public MedicalAppointment(Date date, String historic) {
        this.date = date;
        this.historic = historic;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }
    
    
}

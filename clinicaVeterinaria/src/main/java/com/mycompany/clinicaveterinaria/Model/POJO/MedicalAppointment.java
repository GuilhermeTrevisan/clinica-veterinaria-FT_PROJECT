/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.POJO;

/**
 *
 * @author g170959
 */
public class MedicalAppointment {
    private int id;
    private String date;
    private String historic;
    private int animalId;
    private int veterinaryId;
    private int treatmentId;

    public MedicalAppointment(int id, String date, String historic, int animalId, int veterinaryId, int treatmentId) {
        this.id = id;
        this.date = date;
        this.historic = historic;
        this.animalId = animalId;
        this.veterinaryId = veterinaryId;
        this.treatmentId = treatmentId;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getVeterinaryId() {
        return veterinaryId;
    }

    public void setVeterinaryId(int veterinaryId) {
        this.veterinaryId = veterinaryId;
    }

    public int getTreatment_id() {
        return treatmentId;
    }

    public void setTreatment_id(int treatment_id) {
        this.treatmentId = treatment_id;
    }
    
    @Override
    public String toString() {
        return this.date + ", " + this.historic + ", " + this.animalId + ", " + this.veterinaryId + ", " + this.treatmentId +  " \n";
    }
}

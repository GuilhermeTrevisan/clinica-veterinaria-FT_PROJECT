/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.POJO;

/**
 *
 * @author g170959
 */
public class Treatment {
    private int id;
    private String startDate;
    private String finishDate;
    private int animalId;

    public Treatment(int id, String startDate, String finishDate, int animalId) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.animalId = animalId;
    }
    
    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    
    @Override
    public String toString() {
        return this.startDate + ", " + this.finishDate + " \n";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.POJO;
import java.util.Date;

/**
 *
 * @author g170959
 */
public class Treatment {
    private int id;
    private Date startDate;
    private Date finishDate;

    public Treatment(Date startDate, Date finishDate) {
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
    
    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    
    @Override
    public String toString() {
        return this.startDate + ", " + this.finishDate + " \n";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model;
import com.mycompany.clinicaveterinaria.Controller.UpdateScreenInterface;

/**
 *
 * @author Guizera
 */
public class DummyUpdateScreen implements UpdateScreenInterface {
    
    @Override
    public void reloadScreen() {
        return;
    }

    @Override
    public void updateClient(boolean update) {
        return;
    }
    
    @Override
    public void finishTreatment(boolean finish) {
        return;
    }
}
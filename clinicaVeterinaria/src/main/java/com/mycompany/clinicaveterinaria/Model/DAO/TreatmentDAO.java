/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.DAO;

import static com.mycompany.clinicaveterinaria.Model.DAO.DAO.getConnection;
import com.mycompany.clinicaveterinaria.Model.POJO.Treatment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guizera
 */
public class TreatmentDAO extends DAO {
    public TreatmentDAO() {
        getConnection();
        createAllTables();
    }

    public List<Treatment> getAllTreatments() {
        List<Treatment> treatments = new ArrayList();
        String query = "SELECT * FROM treatment";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                treatments.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return treatments;
    }
    
    public Treatment getTreatmentById(int id) {
        String query = "SELECT * FROM treatment WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Treatment treatment = null;
        try {
            treatment = new Treatment(rs.getString("initDate"), rs.getString("finishDate"), rs.getInt("id_animal"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return treatment;
    }
    
    public void insertNewTreatment(String initDate, String finishDate, int animalId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO treatment (id_animal, initDate, finishDate) VALUES (?,?,?)");
            stmt.setInt(1, animalId);
            stmt.setString(2, initDate);
            stmt.setString(3, finishDate);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTreatmentById(int id, String initDate, String finishDate, int animalId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE treatment SET id_animal=?, initDate=?, finishDate=? WHERE id=?");
            stmt.setInt(1, animalId);
            stmt.setString(2, initDate);
            stmt.setString(3, finishDate);
            stmt.setInt(4, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteTreatmentById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM treatment WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private Treatment buildObject(ResultSet rs) {
        Treatment treatment = null;
        try {
            treatment = new Treatment(rs.getString("initDate"), rs.getString("finishDate"), rs.getInt("id_animal"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return treatment;
    }
}

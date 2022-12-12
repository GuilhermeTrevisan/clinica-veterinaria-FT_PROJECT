/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.DAO;

import static com.mycompany.clinicaveterinaria.Model.DAO.DAO.getConnection;
import com.mycompany.clinicaveterinaria.Model.POJO.MedicalAppointment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guizera
 */
public class MedicalAppointmentDAO extends DAO {
    
    public MedicalAppointmentDAO() {
        getConnection();
        createAllTables();
    }

    public List<MedicalAppointment> getAllAppointments() {
        List<MedicalAppointment> appoints = new ArrayList();
        String query = "SELECT * FROM appointment";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                appoints.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return appoints;
    }
    
    public MedicalAppointment getAppointmentById(int id) throws ParseException {
        String query = "SELECT * FROM appointment WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        MedicalAppointment appoint = null;
        try {
            appoint = new MedicalAppointment(rs.getInt("id"), rs.getString("date"), rs.getString("historic"), rs.getInt("id_animal"), rs.getInt("id_vet"), rs.getInt("id_tratamento"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return appoint;
    }
    
    public List<MedicalAppointment> getAppointmentByDate(String date) throws ParseException {
        List<MedicalAppointment> appoints = new ArrayList();
        String query = "SELECT * FROM appointment WHERE date LIKE '%" + date + "%'";
        ResultSet rs = getResultSet(query);

        try {
            while (rs.next()) {
                appoints.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return appoints;
    }
    
    public void insertNewAppointment(String date, String historic, int animalId, int vetId, int treatmentId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO appointment (date, historic, id_animal, id_vet, id_tratamento) VALUES (?,?,?,?,?)");
            stmt.setString(1, date);
            stmt.setString(2, historic);
            stmt.setInt(3, animalId);
            stmt.setInt(4, vetId);
            stmt.setInt(5, treatmentId);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(MedicalAppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAppointmentById(int id, String date, String historic, int animalId, int vetId, int treatmentId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE appointment SET date=?, historic=?, id_animal=?, id_vet=?, id_tratamento=? WHERE id=?");
            stmt.setString(1, date);
            stmt.setString(2, historic);
            stmt.setInt(3, animalId);
            stmt.setInt(4, vetId);
            stmt.setInt(5, treatmentId);
            stmt.setInt(6, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void updateHistoricById(int id, String historic) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE appointment SET historic=? WHERE id=?");
            stmt.setString(1, historic);
            stmt.setInt(2, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteAppointmentById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM appointment WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private MedicalAppointment buildObject(ResultSet rs) {
        MedicalAppointment appoint = null;
        try {
            appoint = new MedicalAppointment(rs.getInt("id"), rs.getString("date"), rs.getString("historic"), rs.getInt("id_animal"), rs.getInt("id_vet"), rs.getInt("id_tratamento"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return appoint;
    }
}

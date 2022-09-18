/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.DAO;

import static com.mycompany.clinicaveterinaria.Model.DAO.DAO.getConnection;
import com.mycompany.clinicaveterinaria.Model.POJO.Exam;
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
public class ExamDAO extends DAO {

    public ExamDAO() {
        getConnection();
        createAllTables();
    }

    public List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList();
        String query = "SELECT * FROM exam";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                exams.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exams;
    }
    
    public Exam getExamById(int id) {
        String query = "SELECT * FROM exam WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Exam exam = null;
        try {
            exam = new Exam(rs.getString("description"), rs.getInt("appointment_id"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exam;
    }
    
    public void insertNewExam(String description, int appointmentId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exam (description, appointment_id) VALUES (?,?)");
            stmt.setString(1, description);
            stmt.setInt(2, appointmentId);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateExamById(int id, String description, int appointmentId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exam SET description=?, appointment_id=? WHERE id=?");
            stmt.setString(1, description);
            stmt.setInt(2, appointmentId);
            stmt.setInt(3, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteExamById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM exam WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private Exam buildObject(ResultSet rs) {
        Exam exam = null;
        try {
            exam = new Exam(rs.getString("description"), rs.getInt("appointment_id"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exam;
    }
}

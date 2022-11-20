/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.DAO;

import static com.mycompany.clinicaveterinaria.Model.DAO.DAO.getConnection;
import com.mycompany.clinicaveterinaria.Model.POJO.Veterinary;
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
public class VeterinaryDAO extends DAO {
    
    public VeterinaryDAO() {
        getConnection();
        createAllTables();
    }

    public List<Veterinary> getAllVeterinaries() {
        List<Veterinary> veterinaries = new ArrayList();
        String query = "SELECT * FROM veterinary";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                veterinaries.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinaries;
    }
    
    public Veterinary getVeterinaryById(int id) {
        String query = "SELECT * FROM veterinary WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Veterinary veterinary = null;
        try {
            veterinary = new Veterinary(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("number"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinary;
    }
    
    public void insertNewVeterinary(String name, String address, String number) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO veterinary (name, address, number) VALUES (?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, number);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateVeterinaryById(int id, String name, String address, String number) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinary SET name=?, address=?, number=? WHERE id=?");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, number);
            stmt.setInt(4, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteVeterinaryById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM veterinary WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private Veterinary buildObject(ResultSet rs) {
        Veterinary veterinary = null;
        try {
            veterinary = new Veterinary(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("number"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinary;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicaveterinaria.Model.DAO;

import static com.mycompany.clinicaveterinaria.Model.DAO.DAO.getConnection;
import com.mycompany.clinicaveterinaria.Model.POJO.Species;
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
public class SpeciesDAO extends DAO {
    public SpeciesDAO() {
        getConnection();
        createAllTables();
    }

    public List<Species> getAllSpecies() {
        List<Species> species = new ArrayList();
        String query = "SELECT * FROM species";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                species.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return species;
    }
    
    public Species getSpeciesById(int id) {
        String query = "SELECT * FROM species WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Species species = null;
        try {
            species = new Species(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return species;
    }
    
    public void insertNewSpecies(String name) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO species (name) VALUES (?)");
            stmt.setString(1, name);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(SpeciesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSpeciesById(int id, String name) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE species SET name=? WHERE id=?");
            stmt.setString(1, name);
            stmt.setInt(2, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteSpeciesById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM species WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private Species buildObject(ResultSet rs) {
        Species species = null;
        try {
            species = new Species(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return species;
    }
}

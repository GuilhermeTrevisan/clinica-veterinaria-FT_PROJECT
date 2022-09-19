package com.mycompany.clinicaveterinaria.Model.DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
    public static final String DBURL = "jdbc:sqlite:vet2022.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void closeConnection() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    protected final boolean createAllTables() {
        try {
            PreparedStatement stmt;
            // Client:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS client( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "address VARCHAR, \n"
                    + "cep VARCHAR, \n"
                    + "email VARCHAR, \n"
                    + "number VARCHAR); \n");
            executeUpdate(stmt);
            // Animal:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "genre VARCHAR, \n"
                    + "species_id INTEGER, \n"
                    + "client_id INTEGER); \n");
            executeUpdate(stmt);
            // Species:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS species( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR); \n");
            executeUpdate(stmt);
            // Veterinary:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS veterinary( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "address VARCHAR, \n"
                    + "number VARCHAR); \n");
            executeUpdate(stmt);        
            // Treatment:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS treatment( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "id_animal INTEGER, \n"
                    + "initDate TEXT, \n"
                    + "finishDate TEXT); \n");
            executeUpdate(stmt);
            // Appointment:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS appointment( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "date DATE, \n"
                    + "historic VARCHAR, \n"
                    + "id_animal INTEGER, \n"
                    + "id_vet INTEGER, \n"
                    + "id_tratamento INTEGER); \n");
            executeUpdate(stmt);            
             // Exam:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exam( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "description VARCHAR, \n"
                    + "appointment_id INTEGER); \n");
            executeUpdate(stmt);
            // Default element for species:
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO species (id, name) VALUES (1, 'Cachorro')");
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

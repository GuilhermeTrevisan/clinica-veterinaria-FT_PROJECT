package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends DAO {

    public ClientDAO() {
        getConnection();
        createAllTables();
    }

    public List<Client> getAllUsers() {
        List<Client> clientes = new ArrayList();
        String query = "SELECT * FROM client";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clientes;
    }
    
    public Client getUserById(int id) {
        String query = "SELECT * FROM client WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Client cliente = null;
        try {
            cliente = new Client(rs.getString("name"), rs.getString("address"), rs.getString("number"), Long.parseLong(rs.getString("cep")), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }
    
    public void insertNewClient(String name, String address, String number, long cep, String email) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO client (name, address, number, cep, email) VALUES (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, number);
            stmt.setLong(4, cep);
            stmt.setString(5, email);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateClientById(int id, String name, String address, String number, long cep, String email) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE client SET name=?, addres=?, number=?, cep=?, email=? WHERE id=?");
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, number);
            stmt.setLong(4, cep);
            stmt.setString(5, email);
            stmt.setInt(6, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteClientById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM client WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private Client buildObject(ResultSet rs) {
        Client cliente = null;
        try {
            cliente = new Client(rs.getString("name"), rs.getString("address"), rs.getString("number"), rs.getLong("cep"), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }
}
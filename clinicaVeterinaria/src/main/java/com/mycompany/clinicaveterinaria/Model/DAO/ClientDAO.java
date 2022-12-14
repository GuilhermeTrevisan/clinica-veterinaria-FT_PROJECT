package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.POJO.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
    
    public List<Client> getAllClientsByName(String name) throws ParseException {
        List<Client> clients = new ArrayList();
        String query = "SELECT * FROM client WHERE name LIKE '%" + name + "%'";
        ResultSet rs = getResultSet(query);

        try {
            while (rs.next()) {
                clients.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clients;
    }
    
    public List<String> getAllClientsName() {
        List<Client> clients = new ArrayList();
        String query = "SELECT * FROM client";
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clients.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        
        List<String> clientNames = new ArrayList();
        for(int i = 0; i < clients.size(); i++) {
            clientNames.add(i, clients.get(i).getName());
        }
        
        return clientNames;
    }
    
    public Client getUserById(int id) {
        String query = "SELECT * FROM client WHERE id = " + id;
        ResultSet rs = getResultSet(query);

        Client cliente = null;
        try {
            cliente = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("number"), Long.parseLong(rs.getString("cep")), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }
    
    public Client getClientByName(String name) { 
        String query = "SELECT * FROM client WHERE name = '" + name  + "'";
        ResultSet rs = getResultSet(query);

        Client client = null;
        try {
            client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("number"), Long.parseLong(rs.getString("cep")), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return client;
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
            stmt = DAO.getConnection().prepareStatement("UPDATE client SET name=?, address=?, number=?, cep=?, email=? WHERE id=?");
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
            cliente = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("number"), Long.parseLong(rs.getString("cep")), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }
}
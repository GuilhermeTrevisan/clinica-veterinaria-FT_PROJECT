package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO extends DAO {

    public ClientDAO() {
        getConnection();
        createTable();
    }

    public List<Client> getAllUsers() {
        List<Cliente> clientes = new ArrayList();
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
        String query = "SELECT * FROM client WHERE id = " + id
        ResultSet rs = getResultSet(query);

        Cliente cliente = null;
        try {
            cliente = new Cliente(rs.getString("name"), rs.getString("address"), rs.getString("number"), rs.getString("cep"), rs.getString("email"));
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
            stmt.setString(4, cep);
            stmt.setString(5, email);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateClientById(int id, String name, String address, String number, long cep, String email) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE client SET name=?, addres=?, number=?, cep=?, email=? WHERE id=?");
            stmt.setString(1, name);
            stmt.setString(2, addres);
            stmt.setString(3, number);
            stmt.setString(4, cep);
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

    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            cliente = new Cliente(rs.getString("name"), rs.getString("address"), rs.getString("number"), rs.getString("cep"), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }
}
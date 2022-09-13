package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends DAO {

    public AnimalDAO() {
        getConnection();
        createTable();
    }

    public List<Animal> getAllAnimals()) {
        List<Animal> animais = new ArrayList();
        String query = "SELECT * FROM animal"
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
    
    public Animal getAnimalById(int id) { 
        String query = "SELECT * FROM animal WHERE id = " + id
        ResultSet rs = getResultSet(query);

        Animal animal = null;
        try {
            animal = new Animal(rs.getString("name"), rs.getString("genre"), rs.getString("client_id"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    public void insertNewAnimal(String name, String genre, String speciesId, String clientId) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (name, genre, species_id, client_id) VALUES (?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, genre);
            stmt.setString(3, species_id);
            stmt.setString(4, clientId);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAnimalById(int id, String name, String genre) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET name=?, genre=?, species_id=?, client_id=? WHERE id=?");
            stmt.setString(1, name);
            stmt.setString(2, genre);
            stmt.setString(3, species_id);
            stmt.setString(4, client_id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteAnimalById(int id) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public List<Animal> getAnimalOfUser(int clientId) {
        String query = "SELECT * FROM animal WHERE client_id = " + id
        ResultSet rs = getResultSet(query);

        List<Animal> animals = new ArrayList();
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animals;
    }

    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getString("name"), rs.getString("genre"), rs.getString("client_id"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
}
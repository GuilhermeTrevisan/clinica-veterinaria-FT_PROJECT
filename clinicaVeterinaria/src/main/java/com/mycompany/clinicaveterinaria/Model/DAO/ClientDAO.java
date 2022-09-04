package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO {
    private List<Client> users = new ArrayList<>();

    public ClientDAO() {}

    public List<Client> getAllUsers() {
        return users;
    }
    
    public Client getUserById(int id) { 
        for(int i = 0; i < users.size(); i++) {
        var user = users.get(i);
         if(user.getId() == id) {
            return user;
        }
      }
        return null;
    }
    
    public void insertNewClient(String name, String address, String number, long cep, String email) {
        var newClient = new Client(name, address, number, cep, email);
        users.add(newClient);
    }
    
    public void updateClientById(int id, String name, String address, String number, long cep, String email) {
        for(int i = 0; i < users.size(); i++) {
         var user = users.get(i);
         if(user.getId() == id) {
            user.setName(name);
            user.setAddress(address);
            user.setNumber(number);
            user.setCep(cep);
            user.setEmail(email);
        }
      }
    }
    
    public void deleteClientById(int id) {
        List<Client> newUsers = new ArrayList<>();
        
        for(int i = 0; i < users.size(); i++) {
            var user = users.get(i);
            if(user.getId() != id) {
                newUsers.add(user);
        }
      }
        users = newUsers;
    }
}
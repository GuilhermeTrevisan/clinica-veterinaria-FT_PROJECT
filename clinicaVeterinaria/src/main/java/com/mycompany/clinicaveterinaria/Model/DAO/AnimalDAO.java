package com.mycompany.clinicaveterinaria.Model.DAO;
import com.mycompany.clinicaveterinaria.Model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private List<Animal> animals = new ArrayList<>();

    public AnimalDAO() {}

    public List<Animal> getAllUsers() {
        return animals;
    }
    
    public Animal getAnimalById(int id) { 
        for(int i = 0; i < animals.size(); i++) {
        var animal = animals.get(i);
         if(animal.getId() == id) {
            return animal;
        }
      }
        return null;
    }
    
    public void insertNewAnimal(String name, String genre) {
        var newAnimal = new Animal(name, genre);
        animals.add(newAnimal);
    }
    
    public void updateAnimalById(int id, String name, String genre) {
        for(int i = 0; i < animals.size(); i++) {
         var animal = animals.get(i);
         if(animal.getId() == id) {
            animal.setName(name);
            animal.setGenre(genre);
        }
      }
    }
    
    public void deleteAnimalById(int id) {
        List<Animal> newAnimals = new ArrayList<>();
        
        for(int i = 0; i < animals.size(); i++) {
            var animal = animals.get(i);
            if(animal.getId() != id) {
                newAnimals.add(animal);
        }
      }
        animals = newAnimals;
    }

    public List<Animal> getAnimalOfUser(int clientId) {
        List<Animal> clientAnimals = new ArrayList<>();

        for(int i = 0; i < animals.size(); i++) {
            var animal = animals.get(i);
            if(animal.getClientId() == clientId) {
                clientAnimals.add(animal);
        }
      }
      return clientAnimals;
    }
}
package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.services;

import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.repository.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//En aquesta classe entra la logica de negoci
@Service
public class FruitServices {

    @Autowired
    FruitRepo fruitRepository;

    public Fruit crateFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    public boolean existsById (int id){
        return fruitRepository.existsById(id);
    }

    public Fruit updateFruit(Fruit fruit, int id){
        Fruit existingFruit = fruitRepository.findById(fruit.getId()).get();
        existingFruit.setNom(fruit.getNom());
        existingFruit.setQuantitatQuilos(fruit.getQuantitatQuilos());
        Fruit updatedFruit = fruitRepository.save(existingFruit);
        return updatedFruit;

    }
    public void deleteFruit(int id){
        fruitRepository.deleteById(id);
    }
    public Fruit getFruitById(int id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        return optionalFruit.get();
    }
    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }

}

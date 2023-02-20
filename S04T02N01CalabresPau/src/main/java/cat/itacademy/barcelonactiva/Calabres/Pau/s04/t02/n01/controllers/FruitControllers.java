package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.model.services.FruitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//En aquesta classe tenim el mètodes per buscar, afegir i eliminar de la taula fruites
@RestController
@RequestMapping("/fruita")
public class FruitControllers {

    @Autowired
    FruitServices fruitServices;

    @PostMapping ("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit){
        try {
            Fruit newfruit = fruitServices.crateFruit(new Fruit(fruit.getNom(), fruit.getQuantitatQuilos()));
            return new ResponseEntity<>(newfruit, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") int id, @RequestBody Fruit fruit) {
        if (fruitServices.existsById(id)){
        Fruit updateFruit = fruitServices.updateFruit(fruit, id);
        return new ResponseEntity<>(updateFruit, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") int id) {
        try{
            if (fruitServices.existsById(id)){
                fruitServices.deleteFruit(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getOne/{id}")
    public  ResponseEntity<Fruit> getFruitbyId(@PathVariable("id") int id) {

        if(fruitServices.existsById(id)) {
            Fruit fruit = fruitServices.getFruitById(id);
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruits = fruitServices.getAllFruits();
            if (fruits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

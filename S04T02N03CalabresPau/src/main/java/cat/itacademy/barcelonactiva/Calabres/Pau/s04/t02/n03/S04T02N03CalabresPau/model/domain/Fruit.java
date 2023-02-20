package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//Aquesta classe genera la taula Fruites
@Data
@NoArgsConstructor
@Document(collection = "Fruits")
public class Fruit {

    @Id
    private int id;

    private String nom;

    private int quantitatQuilos;

    public Fruit(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }
}

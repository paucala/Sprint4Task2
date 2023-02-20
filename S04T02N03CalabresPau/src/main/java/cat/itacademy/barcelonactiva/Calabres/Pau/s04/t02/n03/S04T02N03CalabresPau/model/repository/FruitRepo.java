package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.repository;



import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepo  extends MongoRepository<Fruit, Integer> {
    /* Aqui podriem afegir altres metodes de busca, com per exemple un per buscar pel nom
    (que podria buscar matches com per exemple totes les que comencin per una lletra...)
    List<Fruit> findByName(String name);*/
}

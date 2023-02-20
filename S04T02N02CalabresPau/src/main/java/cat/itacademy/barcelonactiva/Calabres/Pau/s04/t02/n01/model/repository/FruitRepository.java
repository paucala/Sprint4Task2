package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    /* Aqui podriem afegir altres metodes de busca, com per exemple un per buscar pel nom
    (que podria buscar matches com per exemple totes les que comencin per una lletra...)
    List<Fruit> findByName(String name);*/
}

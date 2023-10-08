package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.repository;

import cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitaRepository extends MongoRepository<Fruita,String> {
}


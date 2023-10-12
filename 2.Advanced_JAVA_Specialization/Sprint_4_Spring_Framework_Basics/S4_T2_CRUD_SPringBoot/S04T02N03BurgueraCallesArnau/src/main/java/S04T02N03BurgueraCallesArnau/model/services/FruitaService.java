package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.services;

import cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.domain.Fruita;
import cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {
    private final FruitaRepository fruitaRepository;

    @Autowired
    public FruitaService(FruitaRepository fruitaRepository) {
        this.fruitaRepository = fruitaRepository;
    }

    //add
    public Fruita addFruita(Fruita fruita){
        return fruitaRepository.save(fruita);
    }

    public Fruita updateFruita(String id, String nouNom, int novaQuantitatKg){
        Optional<Fruita> fruitValida = fruitaRepository.findById((id));

        if(fruitValida.isPresent()){
            Fruita fruitaToUpdate = fruitValida.get();
            fruitaToUpdate.setNom(nouNom);
            fruitaToUpdate.setQuantitatQuilos(novaQuantitatKg);
            fruitaRepository.save(fruitaToUpdate);
            return fruitaToUpdate;
        }else{
            return null;
        }
    }

    //delete
    public void deleteFruitaById(String id) {
        fruitaRepository.deleteById((id));
    }

    //getOne
    public Optional<Fruita> getFruitaById(String id) {
        return fruitaRepository.findById((id));
    }

    //getAll
    public List<Fruita> getAllFruitas() {
        return fruitaRepository.findAll();
    }
}


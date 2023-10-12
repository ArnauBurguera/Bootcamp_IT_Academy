package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.controllers;

import cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.domain.Fruita;
import cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
    private final FruitaService fruitaService;

    @Autowired
    public FruitaController(FruitaService fruitaService) {
        this.fruitaService = fruitaService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita){
        Fruita addedFruita = fruitaService.addFruita(fruita);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedFruita);
    }
    /*
    Aquest et pot donar problemes pq aquí potser és
    per quan tinguessis un save() en el metode de services
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(
            @PathVariable String id,
            @RequestParam String nouNom,
            @RequestParam int novaQuantitatKg
    ){
        Fruita updatedFruita = fruitaService.updateFruita(id, nouNom, novaQuantitatKg);
        if (updatedFruita != null){
            return ResponseEntity.ok(updatedFruita);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable String id){
        fruitaService.deleteFruitaById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable String id){
        Optional<Fruita> fruitaOptional = fruitaService.getFruitaById(id);

        if(fruitaOptional.isPresent()){
            return ResponseEntity.ok(fruitaOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<Fruita>> getAllFruitas(){
        List<Fruita> fruitas = fruitaService.getAllFruitas();
        return ResponseEntity.ok(fruitas);
    }
}


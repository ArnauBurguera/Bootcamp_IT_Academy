package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau.model.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fruita")//Així nombrem la col·lecció q crearà
public class Fruita {
    @Id
    private String id;//Mongodb treball amb String per id per anar millor
    @Field("nom")
    private String nom;
    @Field("quantitatQuilos")
    private int quantitatQuilos;

    public Fruita() {

    }
    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public String getId() {
        return this.id;
    }
    /*public void setId(String id) {
        this.id = id;
    }*/

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return this.quantitatQuilos;
    }
    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }
}

package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n01.S04T02N01BurgueraCallesArnau.model.domain;

import jakarta.persistence.*;

@Entity
public class Fruita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nom;
    @Column
    private int quantitatQuilos;

    public Fruita() {

    }
    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public int getId() {
        return this.id;
    }
    /*public void setId(int id) {
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

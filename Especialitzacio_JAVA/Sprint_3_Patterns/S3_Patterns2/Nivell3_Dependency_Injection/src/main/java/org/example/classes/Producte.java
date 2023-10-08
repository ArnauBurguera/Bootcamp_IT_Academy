package org.example.classes;

public class Producte {

    private String nom;
    private double preuEuros;

    public Producte(String nom, double preuEuros) {
        this.nom = nom;
        this.preuEuros = preuEuros;
    }

    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreuEuros() {
        return this.preuEuros;
    }
    public void setPreuEuros(double preuEuros) {
        this.preuEuros = preuEuros;
    }

    @Override
    public String toString(){
        return "Nom: " + this.nom + "   Preu: " + this.preuEuros + "€";
    }
}

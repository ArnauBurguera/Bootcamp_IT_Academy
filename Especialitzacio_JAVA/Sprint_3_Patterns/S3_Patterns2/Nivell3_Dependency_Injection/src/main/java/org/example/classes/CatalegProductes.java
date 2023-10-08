package org.example.classes;

import org.example.interfaces.CanviDivises;

import java.util.ArrayList;
import java.util.List;

public class CatalegProductes {

    private List<Producte> productes;
    private CanviDivises canviDivises;

    public CatalegProductes(CanviDivises canviDivises) {
        this.productes = new ArrayList<>();
        this.canviDivises = canviDivises;
        /*Aquí té lloc la injecció de dependència, on li passem una implementació
        de la interface CanviDivises pel constructor quan creem un objecte CatalegProductes
         */
    }

    public void addProducte(Producte producte){
        productes.add(producte);
    }

    public void removeProducte(Producte producte){
        productes.remove(producte);
    }

    public void mostrarProductes(){
        this.productes.stream()
                .map(Object::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    public String convertirDivises(String nomProducte, double preuEuros, String novaDivisa){
        double resultat = canviDivises.convertir(preuEuros,novaDivisa);
        return "El preu de [" + nomProducte + "] en [" + novaDivisa + "] és de " + resultat + " unitats.";
    }



}

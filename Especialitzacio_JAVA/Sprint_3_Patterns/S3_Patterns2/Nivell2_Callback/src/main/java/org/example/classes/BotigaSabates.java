package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class BotigaSabates {
    private String nom;
    private List<PassarellaPagament> llistaPagaments;

    public BotigaSabates(String nom) {
        this.nom = nom;
        this.llistaPagaments = new ArrayList<PassarellaPagament>();
    }

    public void addCompra(PassarellaPagament compra){
        this.llistaPagaments.add(compra);
    }
}

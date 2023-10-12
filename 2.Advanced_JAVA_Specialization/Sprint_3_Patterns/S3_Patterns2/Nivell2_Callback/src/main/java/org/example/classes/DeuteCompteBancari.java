package org.example.classes;

import org.example.callback.Pagament;

public class DeuteCompteBancari implements Pagament {
    @Override
    public String pagar() {
        return "Mètode de pagament: Deute compte bancari";
    }
}

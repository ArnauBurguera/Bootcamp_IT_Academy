package org.example.classes;

import org.example.interfaces.CanviDivises;

import java.util.Map;

public class Conversio implements CanviDivises {

    private Map<String, Double> ratiosConversio;

    public Conversio(Map<String, Double> ratiosConversio) {
        this.ratiosConversio = ratiosConversio;
    }

    @Override
    public double convertir(double preuEuros, String novaDivisa) {
        double ratioConversio = ratiosConversio.get(novaDivisa);
        return preuEuros * ratioConversio;
    }
}

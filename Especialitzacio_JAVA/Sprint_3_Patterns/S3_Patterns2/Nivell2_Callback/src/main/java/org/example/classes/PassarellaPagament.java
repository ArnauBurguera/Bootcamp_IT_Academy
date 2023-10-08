package org.example.classes;

import org.example.callback.Pagament;

public class PassarellaPagament {
    private final Pagament metodePagament;
    private double preu;

    public PassarellaPagament(Pagament metodePagament, double preu) {
        this.metodePagament = metodePagament;
        this.preu = preu;
    }

    public String efectuarCompra(){
        System.out.println("Efectuant compra. COST TOTAL: " + this.preu + "€");
        return metodePagament.pagar();
    }
}

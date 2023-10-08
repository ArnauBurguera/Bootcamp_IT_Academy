package org.example.client;

import org.example.callback.Pagament;
import org.example.classes.BotigaSabates;
import org.example.classes.DeuteCompteBancari;
import org.example.classes.PassarellaPagament;
import org.example.classes.Paypal;

public class Main {
    public static void main(String[] args) {

        BotigaSabates botiga1 = new BotigaSabates("La pezuña");

        //Compra 1
        Pagament tipusPago1 = new DeuteCompteBancari();
        PassarellaPagament compra1 = new PassarellaPagament(tipusPago1,79.99d);
        String rebut1 = compra1.efectuarCompra();

        System.out.println(rebut1);

        //Compra 2
        Pagament tipusPago2 = new Paypal();
        PassarellaPagament compra2 = new PassarellaPagament(tipusPago2,112.99d);
        String rebut2 = compra2.efectuarCompra();

        System.out.println(rebut2);

        botiga1.addCompra(compra1);
        botiga1.addCompra(compra2);

    }
}
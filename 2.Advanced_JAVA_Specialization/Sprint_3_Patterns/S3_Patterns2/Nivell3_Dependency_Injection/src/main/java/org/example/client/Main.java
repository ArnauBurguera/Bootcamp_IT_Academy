package org.example.client;

import org.example.classes.CatalegProductes;
import org.example.classes.Conversio;
import org.example.classes.Producte;
import org.example.interfaces.CanviDivises;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Double> ratiosConversio = new HashMap<>();
        ratiosConversio.put("USD",1.11);
        ratiosConversio.put("Corona danesa",7.45);
        ratiosConversio.put("Chelins",157.29);
        ratiosConversio.put("Dòlar Jamaicà",171.34);
        ratiosConversio.put("Yuan chinès extracontinental",7.9);

        CanviDivises canviDivises = new Conversio(ratiosConversio);
        //Injecció de dependència (CatalegProductes depèn d'un objecte CanviDivises per funcionar)
        CatalegProductes cataleg = new CatalegProductes(canviDivises);


        Producte producte1 = new Producte("Xampú", 2.99d);
        Producte producte2 = new Producte("Carmanyola", 1.85d);
        Producte producte3 = new Producte("Xancletes", 8.99d);

        cataleg.addProducte(producte1);
        cataleg.addProducte(producte2);
        cataleg.addProducte(producte3);

        cataleg.mostrarProductes();

        System.out.println(cataleg.convertirDivises(producte1.getNom(), producte1.getPreuEuros(),"Dòlar Jamaicà"));
        System.out.println(cataleg.convertirDivises(producte2.getNom(), producte2.getPreuEuros(),"Yuan chinès extracontinental"));
        System.out.println(cataleg.convertirDivises(producte3.getNom(), producte3.getPreuEuros(),"Corona danesa"));



    }
}
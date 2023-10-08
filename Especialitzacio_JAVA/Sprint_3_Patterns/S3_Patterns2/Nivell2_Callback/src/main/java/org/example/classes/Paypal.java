package org.example.classes;

import org.example.callback.Pagament;

public class Paypal implements Pagament {
    @Override
    public String pagar() {
        return "Mètode de pagament: Paypal";
    }
}


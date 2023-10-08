package org.example.classes;

import org.example.callback.Pagament;

public class TargetaCredit implements Pagament {
    @Override
    public String pagar() {
        return "Mètode de pagament: Targeta de crèdit";
    }
}

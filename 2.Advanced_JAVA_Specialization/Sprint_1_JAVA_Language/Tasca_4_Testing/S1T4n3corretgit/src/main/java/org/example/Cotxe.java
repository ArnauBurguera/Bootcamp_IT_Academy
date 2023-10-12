package org.example;

public class Cotxe {
    private String color;
    private int potencia;
    public Cotxe(String color, int potencia) {
        super();
        this.color = color;
        this.potencia = potencia;
    }
    public String getColor() {
        return color;
    }
    public int getPotencia() {
        return potencia;
    }

    public void tiraExcepcio() {
        Integer[] array = {1,2,3};
        int a = array[3];

    }
}

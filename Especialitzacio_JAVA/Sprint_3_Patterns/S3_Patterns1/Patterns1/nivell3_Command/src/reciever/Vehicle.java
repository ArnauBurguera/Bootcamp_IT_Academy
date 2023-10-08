package reciever;

public interface Vehicle {

    default public void accelerar(){
        System.out.println("Accelerant");
    }

    default public void arrencant(){
        System.out.println("Arrencant");
    }

    default public void frenar(){
        System.out.println("Frenant");
    }
}

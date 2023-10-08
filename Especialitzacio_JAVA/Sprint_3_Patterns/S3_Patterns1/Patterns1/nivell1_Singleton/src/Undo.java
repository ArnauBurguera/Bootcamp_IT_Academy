import java.util.ArrayList;

public class Undo {

    //Creem un paràmetre que contè un objecte null de la classe Undo
    private static Undo instance;
    private ArrayList<String> comandes = new ArrayList<String>();

    //Creem el mètode privat per a que ningú pugui instanciar la classe
    private Undo(){}

    //Aquest és el mètode que retorna la única instància de la classe Undo
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public ArrayList<String> getComandes() {
        return this.comandes;
    }

    public void setComandes(ArrayList<String> comandes) {
        this.comandes = comandes;
    }

    public void llistaComandes() {
        comandes.forEach(System.out::println);
    }

    public void undoUltimaComanda(){
        this.comandes.remove(this.comandes.size()-1);
    }

    public void addComanda(String comanda){
        this.comandes.add(comanda);
    }
}


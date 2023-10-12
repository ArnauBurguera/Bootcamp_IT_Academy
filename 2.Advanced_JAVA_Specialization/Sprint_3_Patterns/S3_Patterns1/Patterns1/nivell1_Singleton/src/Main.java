// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //En el moment en que accedim al mètode static de la classe Undo, s'instancia la classe.
        Undo undoComando = Undo.getInstance();

        //Afegir comandes
        undoComando.addComanda("Comanda 1");
        undoComando.addComanda("Comanda 2");
        undoComando.addComanda("Comanda 3");
        undoComando.addComanda("Comanda 4");

        undoComando.llistaComandes();
        System.out.println();

        //Undo comando com a tal
        undoComando.undoUltimaComanda();

        undoComando.llistaComandes();


    }
}
package client;

import commands.Accelerar;
import commands.Arrencar;
import invoker.Invoker;
import reciever.Avio;
import reciever.Cotxe;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Instanciar objecte que implementi vehicle
        Avio avio = new Avio();
        Cotxe paganiZondaCinqueRoadster = new Cotxe();

        //Instanciar comanda
        Accelerar accelerarAvio = new Accelerar(avio);
        Arrencar arrencarPagani = new Arrencar(paganiZondaCinqueRoadster);

        //Instanciar objecte invoker
        Invoker invoker = new Invoker();

        //Fer que el invoker rebi comanda
        invoker.rebreCommand(accelerarAvio);
        invoker.rebreCommand(arrencarPagani);

        //Fer que el invoker executi la comanda
        invoker.executarCommands();
        }
    }
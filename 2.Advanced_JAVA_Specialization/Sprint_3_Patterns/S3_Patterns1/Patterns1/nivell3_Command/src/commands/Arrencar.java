package commands;

import reciever.Vehicle;

public class Arrencar implements Command{
    private Vehicle vehicle = null;

    public Arrencar(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
    vehicle.arrencant();
    }
}

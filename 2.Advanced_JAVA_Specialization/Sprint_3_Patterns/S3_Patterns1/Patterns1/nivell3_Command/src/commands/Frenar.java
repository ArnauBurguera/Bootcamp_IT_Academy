package commands;

import reciever.Vehicle;

public class Frenar implements Command{
    private Vehicle vehicle = null;

    public Frenar(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
    vehicle.frenar();
    }
}

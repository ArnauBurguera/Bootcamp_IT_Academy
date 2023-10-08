package commands;

import reciever.Vehicle;

public class Accelerar implements Command{
    private Vehicle vehicle = null;

    public Accelerar(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
    vehicle.accelerar();
    }
}

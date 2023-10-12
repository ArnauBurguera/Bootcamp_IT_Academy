package implementations;

import interfaces.Address;

public class SpainAddress implements Address {
    @Override
    public String createAddress(String address) {
        return "Address: " + address;
    }
}

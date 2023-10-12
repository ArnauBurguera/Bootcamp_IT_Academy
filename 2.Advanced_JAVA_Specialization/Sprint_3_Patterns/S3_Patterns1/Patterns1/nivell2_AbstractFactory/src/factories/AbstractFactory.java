package factories;

import interfaces.Address;
import interfaces.PhoneNumber;

public interface AbstractFactory {
    Address createAddress(String countryName);
    PhoneNumber createPhoneNumber(String countryName);
}

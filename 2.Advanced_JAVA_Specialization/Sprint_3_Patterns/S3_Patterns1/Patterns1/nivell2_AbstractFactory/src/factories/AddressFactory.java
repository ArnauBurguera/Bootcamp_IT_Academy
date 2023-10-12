package factories;

import implementations.SpainAddress;
import interfaces.Address;
import interfaces.PhoneNumber;

public class AddressFactory implements AbstractFactory{

    @Override
    public Address createAddress(String countryName) {
        if(countryName.equalsIgnoreCase("Spain")){
            return new SpainAddress();
        }else{
            return null;
        }
    }

    @Override
    public PhoneNumber createPhoneNumber(String countryName) {
        return null;
    }
}

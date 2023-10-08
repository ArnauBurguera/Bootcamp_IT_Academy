package factories;

import implementations.SpainPhoneNumber;
import interfaces.Address;
import interfaces.PhoneNumber;

public class PhoneNumberFactory implements AbstractFactory{
    @Override
    public Address createAddress(String countryName) {
        return null;
    }

    @Override
    public PhoneNumber createPhoneNumber(String countryName) {
        if(countryName.equalsIgnoreCase("Spain")){
            return new SpainPhoneNumber();
        }else{
            return null;
        }
    }
}

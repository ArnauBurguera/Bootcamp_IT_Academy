package implementations;

import interfaces.PhoneNumber;

public class SpainPhoneNumber implements PhoneNumber {

    private String countryCallingCode = "";

    public SpainPhoneNumber() {
        this.countryCallingCode = "+34 ";
    }

    @Override
    public String createPhoneNumber(String phoneNumber) {
        return this.countryCallingCode + phoneNumber;
    }
}

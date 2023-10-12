package client;

import factories.AbstractFactory;
import factories.FactoryProvider;
import interfaces.Address;
import interfaces.PhoneNumber;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Agenda
        ArrayList<String> addressesAgenda = new ArrayList<String>();
        ArrayList<String> phoneNumbersAgenda = new ArrayList<String>();

        //Factories creation
        AbstractFactory addressFactory = FactoryProvider.getFactory("Address");
        AbstractFactory phoneNumberFactory = FactoryProvider.getFactory("PhoneNumber");

        //Address creator
        assert addressFactory != null : "addressFactory is null!";
        Address spainAddress = addressFactory.createAddress("Spain");
        //Phone Number creator
        assert phoneNumberFactory != null;
        PhoneNumber spainPhoneNumber = phoneNumberFactory.createPhoneNumber("Spain");


        addressesAgenda.add(spainAddress.createAddress("Plaza de España 25, Vilarmaior, A Coruña(C), 15637"));
        addressesAgenda.add(spainAddress.createAddress("Reiseñor 5, Tavernes Blanques, Valencia(V), 46016"));
        addressesAgenda.add(spainAddress.createAddress("Pza. Fuensanta 17, Cortegada, Ourense(OR), 32200"));
        addressesAgenda.add(spainAddress.createAddress("Av. Zumalakarregi 91, Orihuela, Alicante(A), 03300"));

        phoneNumbersAgenda.add(spainPhoneNumber.createPhoneNumber("754 670 385"));
        phoneNumbersAgenda.add(spainPhoneNumber.createPhoneNumber("794 105 577"));
        phoneNumbersAgenda.add(spainPhoneNumber.createPhoneNumber("753 456 100"));
        phoneNumbersAgenda.add(spainPhoneNumber.createPhoneNumber("629 602 265"));

        addressesAgenda.forEach(System.out::println);
        phoneNumbersAgenda.forEach(System.out::println);



    }
}
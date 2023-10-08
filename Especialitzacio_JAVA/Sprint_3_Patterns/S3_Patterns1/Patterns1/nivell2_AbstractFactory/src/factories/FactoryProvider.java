package factories;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Address".equalsIgnoreCase(choice)){
            return new AddressFactory();
        }else if("PhoneNumber".equalsIgnoreCase(choice)){
            return new PhoneNumberFactory();
        }else{
            return null;
        }
    }
}

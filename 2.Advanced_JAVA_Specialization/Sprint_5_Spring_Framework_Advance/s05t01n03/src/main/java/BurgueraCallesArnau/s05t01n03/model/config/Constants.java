package BurgueraCallesArnau.s05t01n03.model.config;

import java.util.List;

public class Constants {
    //Constants
    private final static List<String> EUCountries = List.of("Austria", "Belgium", "Bulgaria", "Croatia",
            "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary",
            "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal",
            "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
    private static final String invalidSucursal = "Invalid sucursal data.";
    private static final String invalidSucursalDTO = "Invalid sucursalDTO data.";

    //Getters
    public static List<String> getEUCountries() {
        return EUCountries;
    }
    public static String getInvalidSucursal(){
        return invalidSucursal;
    }
    public static String getInvalidSucursalDTO(){
        return invalidSucursalDTO;
    }

}


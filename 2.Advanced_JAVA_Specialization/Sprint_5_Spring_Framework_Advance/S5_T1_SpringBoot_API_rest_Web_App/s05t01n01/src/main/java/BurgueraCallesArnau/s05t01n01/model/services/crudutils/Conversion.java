package BurgueraCallesArnau.s05t01n01.model.services.crudutils;

import BurgueraCallesArnau.s05t01n01.model.config.Constants;
import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

public class Conversion {

    //Convert to SucursalDTO methods
    public static SucursalDTO convertToDTO(Sucursal sucursal) {
        Validation.validateSucursal(sucursal);
        return createDTO(sucursal);
    }

    private static SucursalDTO createDTO(Sucursal sucursal) {
        Integer id =  sucursal.getPk_SucursalID();
        String nom = sucursal.getNomSucursal();
        String pais = sucursal.getPaisSucursal();
        String tipus = determineTipusSucursal(sucursal.getPaisSucursal());

        return new SucursalDTO(id,nom,pais,tipus);
    }

    private static String determineTipusSucursal(String paisSucursal) {
        if (Constants.getEUCountries().contains(paisSucursal)) {
            return "UE";
        } else {
            return "Fora UE";
        }
    }

    //Convert to Sucursal methods
   /* public static Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        Validation.validateSucursalDTO(sucursalDTO);
        return createSucursalEntity(sucursalDTO);
    }*/

    /*private static Sucursal createSucursalEntity(SucursalDTO sucursalDTO) {
        Integer id = sucursalDTO.getPk_SucursalID();
        String nom = sucursalDTO.getNomSucursal();
        String pais = sucursalDTO.getPaisSucursal();

        return new Sucursal(id, nom, pais);
    }*/
}

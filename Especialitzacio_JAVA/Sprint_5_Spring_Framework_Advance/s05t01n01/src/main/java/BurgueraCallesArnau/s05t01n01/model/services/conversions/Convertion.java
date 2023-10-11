package BurgueraCallesArnau.s05t01n01.model.services.conversions;

import BurgueraCallesArnau.s05t01n01.model.config.Constants;
import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

public class Convertion {
    private String determineTipusSucursal(String paisSucursal) {
        if (Constants.getEUCountries().contains(paisSucursal)) {
            return "UE";
        } else {
            return "Fora UE";
        }
    }

    public SucursalDTO convertToDTO(Sucursal sucursal) {
        validateSucursal(sucursal);
        return createDTO(sucursal);
    }

    private void validateSucursal(Sucursal sucursal) {
        if (sucursal == null || sucursal.getPk_SucursalID() == null ||
                sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursal());
        }
    }

    private SucursalDTO createDTO(Sucursal sucursal) {
        Integer id =  sucursal.getPk_SucursalID();
        String nom = sucursal.getNomSucursal();
        String pais = sucursal.getPaisSucursal();
        String tipus = determineTipusSucursal(sucursal.getPaisSucursal());

        return new SucursalDTO(id,nom,pais,tipus);
    }

    public static Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        validateSucursalDTO(sucursalDTO);
        return createSucursalEntity(sucursalDTO);
    }

    private static void validateSucursalDTO(SucursalDTO sucursalDTO) {
        if (sucursalDTO == null || sucursalDTO.getPk_SucursalID() == null ||
                sucursalDTO.getNomSucursal() == null || sucursalDTO.getPaisSucursal() == null
                || sucursalDTO.getTipusSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursalDTO());
        }
    }

    private static Sucursal createSucursalEntity(SucursalDTO sucursalDTO) {
        Integer id = sucursalDTO.getPk_SucursalID();
        String nom = sucursalDTO.getNomSucursal();
        String pais = sucursalDTO.getPaisSucursal();

        return new Sucursal(id, nom, pais);
    }
}

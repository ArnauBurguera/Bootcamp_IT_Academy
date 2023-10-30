package BurgueraCallesArnau.s05t01n02.model.services.crudutils;

import BurgueraCallesArnau.s05t01n02.model.config.Constants;
import BurgueraCallesArnau.s05t01n02.model.domain.Sucursal;

public class Validation {
    public static void validateSucursalToPersist(Sucursal sucursal) {
        if (sucursal == null || sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursal());
        }
    }

    public static void validateSucursal(Sucursal sucursal) {
        if (sucursal == null || sucursal.getPk_SucursalID() == null ||
                sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursal());
        }
    }

    /*public static void validateSucursalDTO(SucursalDTO sucursalDTO) {
        if (sucursalDTO == null || sucursalDTO.getPk_SucursalID() == null ||
                sucursalDTO.getNomSucursal() == null || sucursalDTO.getPaisSucursal() == null
                || sucursalDTO.getTipusSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursalDTO());
        }
    }*/
}

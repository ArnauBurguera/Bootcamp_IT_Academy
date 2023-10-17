package BurgueraCallesArnau.s05t01n01.model.services.crudutils;

import BurgueraCallesArnau.s05t01n01.model.config.Constants;
import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

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

    public static void validateSucursalDTO(SucursalDTO sucursalDTO) {
        if (sucursalDTO == null || sucursalDTO.getPk_SucursalID() == null ||
                sucursalDTO.getNomSucursal() == null || sucursalDTO.getPaisSucursal() == null
                || sucursalDTO.getTipusSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursalDTO());
        }
    }
}

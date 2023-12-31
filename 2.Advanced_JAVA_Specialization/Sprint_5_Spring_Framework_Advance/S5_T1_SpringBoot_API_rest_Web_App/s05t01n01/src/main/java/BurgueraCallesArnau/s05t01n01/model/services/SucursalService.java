package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {

    SucursalDTO convertToDTO(Sucursal sucursal);

    Sucursal createSucursal(Sucursal sucursal);

    SucursalDTO updateSucursal(Sucursal sucursal);

    void deleteSucursal(Integer id);

    SucursalDTO getOneSucursal(Integer id);
    Sucursal getSucursalById(Integer id);

    List<SucursalDTO> getAllSucursals();
}

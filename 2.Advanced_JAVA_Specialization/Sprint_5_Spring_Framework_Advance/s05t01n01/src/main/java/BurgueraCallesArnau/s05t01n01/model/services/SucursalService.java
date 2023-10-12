package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {

    SucursalDTO convertToDTO(Sucursal sucursal);

    Sucursal convertToEntity(SucursalDTO sucursalDTO);

    SucursalDTO createSucursal(SucursalDTO sucursalDTO);

    SucursalDTO updateSucursal(SucursalDTO sucursalDTO);

    void deleteSucursal(Integer id);

    Optional<SucursalDTO> getOneSucursal(Integer id);

    List<SucursalDTO> getAllSucursals();
}

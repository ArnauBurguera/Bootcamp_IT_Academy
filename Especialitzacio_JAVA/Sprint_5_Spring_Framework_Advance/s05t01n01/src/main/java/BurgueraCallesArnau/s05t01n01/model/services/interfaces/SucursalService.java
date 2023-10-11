package BurgueraCallesArnau.s05t01n01.model.services.interfaces;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {

    SucursalDTO convertToDTO(Sucursal sucursal);

    Sucursal convertToEntity(SucursalDTO sucursalDTO);

    SucursalDTO createSucursal(SucursalDTO sucursalDTO);

    SucursalDTO updateSucursal(SucursalDTO sucursalDTO);

    void deleteSucursal(Integer id);

    SucursalDTO getOneSucursal(Integer id);

    List<SucursalDTO> getAllSucursals();
}

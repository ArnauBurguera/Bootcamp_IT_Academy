package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SucursalService implements BurgueraCallesArnau.s05t01n01.model.services.interfaces.SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    private String determineTipusSucursal(String paisSucursal) {
        List<String> euCountries = Arrays.asList(
                "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus",
                "Czech Republic", "Denmark", "Estonia", "Finland", "France",
                "Germany", "Greece", "Hungary", "Ireland", "Italy",
                "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands",
                "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"
        );

        if (euCountries.contains(paisSucursal)) {
            return "UE";
        } else {
            return "Fora UE";
        }
    }

    public SucursalDTO convertToDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setPk_SucursalID(sucursal.getPk_SucursalID());
        dto.setNomSucursal(sucursal.getNomSucursal());
        dto.setPaisSucursal(sucursal.getPaisSucursal());

        // Determine tipusSucursal based on paisSucursal
        String tipus = determineTipusSucursal(sucursal.getPaisSucursal());
        dto.setTipusSucursal(tipus);

        return dto;
    }

    @Override
    public Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        return null;
    }

    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Sucursal entity = convertToEntity(sucursalDTO);
        entity = sucursalRepository.save(entity);
        return convertToDTO(entity);
    }

    @Override
    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        return null;
    }

    @Override
    public void deleteSucursal(Integer id) {

    }

    @Override
    public SucursalDTO getOneSucursal(Integer id) {
        return null;
    }

    @Override
    public List<SucursalDTO> getAllSucursals() {
        return null;
    }
}

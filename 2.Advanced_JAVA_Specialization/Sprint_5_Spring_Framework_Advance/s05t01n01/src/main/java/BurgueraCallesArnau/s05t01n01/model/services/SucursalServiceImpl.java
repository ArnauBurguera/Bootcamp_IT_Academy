package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.Conversion;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.UpdateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public SucursalDTO convertToDTO(Sucursal sucursal) {
        return Conversion.convertToDTO(sucursal);
    }

    @Override
    public Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        return Conversion.convertToEntity(sucursalDTO);
    }

    @Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Sucursal entity = convertToEntity(sucursalDTO);
        return convertToDTO(sucursalRepository.save(entity));
    }
    @Override
    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        return UpdateOperation.updateSucursal(sucursalDTO);
    }

    @Override
    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public Optional<SucursalDTO> getOneSucursal(Integer id) {
        Optional<Sucursal> entity = sucursalRepository.findById(id);
        return entity.map(this::convertToDTO);
    }

    @Override
    public List<SucursalDTO> getAllSucursals() {
        List<Sucursal> entities = sucursalRepository.findAll();
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

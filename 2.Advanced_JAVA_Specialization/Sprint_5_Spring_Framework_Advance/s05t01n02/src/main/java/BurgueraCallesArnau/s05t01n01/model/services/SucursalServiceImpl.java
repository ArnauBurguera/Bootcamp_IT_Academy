package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.Conversion;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.UpdateOperation;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.Validation;
import jakarta.persistence.EntityNotFoundException;
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
    public Sucursal createSucursal(Sucursal sucursal) {
        Validation.validateSucursalToPersist(sucursal);
        return sucursalRepository.save(sucursal);
    }

    @Override
    public SucursalDTO updateSucursal(Sucursal sucursal) {
        return UpdateOperation.updateSucursal(sucursal);
    }

    @Override
    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO getOneSucursal(Integer id) {
        Sucursal entity = getSucursalById(id);
        return convertToDTO(entity);
    }
    @Override
    public Sucursal getSucursalById(Integer id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal not found with ID: " + id));
    }

    @Override
    public List<SucursalDTO> getAllSucursals() {
        List<Sucursal> entities = sucursalRepository.findAll();
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

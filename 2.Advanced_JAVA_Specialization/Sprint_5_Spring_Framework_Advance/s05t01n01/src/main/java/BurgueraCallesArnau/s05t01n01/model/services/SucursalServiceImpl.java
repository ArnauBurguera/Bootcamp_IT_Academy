package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.config.Constants;
import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import BurgueraCallesArnau.s05t01n01.model.services.conversions.Conversion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;//Can i have two of these??????

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
        Sucursal entity = convertToEntity(sucursalDTO);
        Sucursal existingEntity = getExistingEntity(entity.getPk_SucursalID());
        Sucursal updatedEntity = updateEntity(existingEntity, entity);
        return convertToDTO(saveEntity(updatedEntity));
    }

    private Sucursal getExistingEntity(Integer id) {
        Optional<Sucursal> existingEntity = sucursalRepository.findById(id);
        if (existingEntity.isPresent()) {
            return existingEntity.get();
        } else {
            throw new EntityNotFoundException("Sucursal with ID " + id + " not found");
        }
    }

    private Sucursal updateEntity(Sucursal existingEntity, Sucursal newEntity) {
        existingEntity.setNomSucursal(newEntity.getNomSucursal());
        existingEntity.setPaisSucursal(newEntity.getPaisSucursal());
        return existingEntity;
    }

    private Sucursal saveEntity(Sucursal entity) {
        return sucursalRepository.save(entity);
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

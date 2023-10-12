package BurgueraCallesArnau.s05t01n01.model.services.update;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.services.conversions.Conversion;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class UpdateOperation {
    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        Sucursal entity = Conversion.convertToEntity(sucursalDTO);
        Sucursal existingEntity = getExistingEntity(entity.getPk_SucursalID());
        Sucursal updatedEntity = updateEntity(existingEntity, entity);
        return Conversion.convertToDTO(saveEntity(updatedEntity));
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
}

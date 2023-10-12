package BurgueraCallesArnau.s05t01n01.model.services.crudutils;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import BurgueraCallesArnau.s05t01n01.model.services.crudutils.Conversion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UpdateOperation {

    @Autowired
    private static SucursalRepository sucursalRepository;
    public static SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        Sucursal entity = Conversion.convertToEntity(sucursalDTO);
        Sucursal existingEntity = getExistingEntity(entity.getPk_SucursalID());
        Sucursal updatedEntity = updateEntity(existingEntity, entity);
        return Conversion.convertToDTO(saveEntity(updatedEntity));
    }

    private static Sucursal getExistingEntity(Integer id) {
        Optional<Sucursal> existingEntity = sucursalRepository.findById(id);
        if (existingEntity.isPresent()) {
            return existingEntity.get();
        } else {
            throw new EntityNotFoundException("Sucursal with ID " + id + " not found");
        }
    }

    private static Sucursal updateEntity(Sucursal existingEntity, Sucursal newEntity) {
        existingEntity.setNomSucursal(newEntity.getNomSucursal());
        existingEntity.setPaisSucursal(newEntity.getPaisSucursal());
        return existingEntity;
    }

    private static Sucursal saveEntity(Sucursal entity) {
        return sucursalRepository.save(entity);
    }
}

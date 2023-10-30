package BurgueraCallesArnau.s05t01n02.model.services.crudutils;

import BurgueraCallesArnau.s05t01n02.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n02.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n02.model.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UpdateOperation {
    private static SucursalRepository sucursalRepository;

    @Autowired
    public UpdateOperation(SucursalRepository sucursalRepository) {
        UpdateOperation.sucursalRepository = sucursalRepository;
    }
    public static SucursalDTO updateSucursal(Sucursal sucursal) {
        Sucursal existingEntity = getExistingEntity(sucursal.getPk_SucursalID());
        Sucursal updatedEntity = updateEntity(existingEntity, sucursal);
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

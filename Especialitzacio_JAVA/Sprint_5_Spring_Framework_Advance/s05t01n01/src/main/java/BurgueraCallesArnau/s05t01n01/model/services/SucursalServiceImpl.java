package BurgueraCallesArnau.s05t01n01.model.services;

import BurgueraCallesArnau.s05t01n01.model.config.Constants;
import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.repository.SucursalRepository;
import BurgueraCallesArnau.s05t01n01.model.services.conversions.Convertion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    private String determineTipusSucursal(String paisSucursal) {
        if (Constants.getEUCountries().contains(paisSucursal)) {
            return "UE";
        } else {
            return "Fora UE";
        }
    }

    public SucursalDTO convertToDTO(Sucursal sucursal) {
        validateSucursal(sucursal);
        return createDTO(sucursal);
    }

    private void validateSucursal(Sucursal sucursal) {
        if (sucursal == null || sucursal.getPk_SucursalID() == null ||
                sucursal.getNomSucursal() == null || sucursal.getPaisSucursal() == null) {
            throw new IllegalArgumentException(Constants.getInvalidSucursal());
        }
    }

    private SucursalDTO createDTO(Sucursal sucursal) {
        Integer id =  sucursal.getPk_SucursalID();
        String nom = sucursal.getNomSucursal();
        String pais = sucursal.getPaisSucursal();
        String tipus = determineTipusSucursal(sucursal.getPaisSucursal());

        return new SucursalDTO(id,nom,pais,tipus);
    }

    @Override
    public Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        return Convertion.convertToEntity(sucursalDTO);
    }


    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Sucursal entity = convertToEntity(sucursalDTO);
        entity = sucursalRepository.save(entity);
        return convertToDTO(entity);
    }

   /* @Override
    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {

        return new SucursalDTO();
    }*/
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

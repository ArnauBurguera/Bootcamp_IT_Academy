package BurgueraCallesArnau.s05t01n03.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SucursalService{
   /* @Autowired
    private SucursalRepository sucursalRepository;*/
   private final WebClient.Builder webClientBuilder;

    @Autowired
    public SucursalService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    /*@Override
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
    }*/
}

package BurgueraCallesArnau.s05t01n03.model.repository;

import BurgueraCallesArnau.s05t01n03.model.domain.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoad {

    private SucursalRepository sucursalRepository;
    //He intentado the mil maneras hacerlo con un data.sql file en resources i
    // con application.properties pero no ha habido manera
    @Autowired
    public void Dataloader(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
        loadSucursals();
    }

    private void loadSucursals() {
        sucursalRepository.save(new Sucursal("Sunrise Electronics", "United States"));
        sucursalRepository.save(new Sucursal("Luna Pharmaceuticals", "Canada"));
        sucursalRepository.save(new Sucursal("Oceanic Foods", "Australia"));
        sucursalRepository.save(new Sucursal("Alpine Sports", "Switzerland"));
        sucursalRepository.save(new Sucursal("Mystic Motors", "United Kingdom"));
        sucursalRepository.save(new Sucursal("Café Parisienne", "France"));
        sucursalRepository.save(new Sucursal("Tropical Treasures", "Brazil"));
        sucursalRepository.save(new Sucursal("Nihon Technologies", "Japan"));
        sucursalRepository.save(new Sucursal("Sahara Oasis", "Morocco"));
        sucursalRepository.save(new Sucursal("Nordic Woodworks", "Sweden"));

    }
}
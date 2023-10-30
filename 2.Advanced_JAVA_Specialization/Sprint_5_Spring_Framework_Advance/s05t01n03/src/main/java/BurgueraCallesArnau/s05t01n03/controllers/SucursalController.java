package BurgueraCallesArnau.s05t01n03.controllers;

import BurgueraCallesArnau.s05t01n03.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n03.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n03.model.services.SucursalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sucursal/")
@Tag(name = "Sucursal Management", description = "Operations pertaining to Sucursal Management")
public class SucursalController {
    private SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/create")
    public Mono<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.createSucursal(sucursal);
    }

    @PutMapping("/update")
    public Mono<SucursalDTO> updateSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.updateSucursal(sucursal);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteSucursal(@PathVariable Integer id) {
        return sucursalService.deleteSucursal(id);
    }

    @GetMapping("/all")
    public Flux<SucursalDTO> getAllSucursals() {
        return sucursalService.getAllSucursals();
    }

    @GetMapping("/get/{id}")
    public Mono<SucursalDTO> getOneSucursal(@PathVariable Integer id) {
        return sucursalService.getOneSucursal(id);
    }

}

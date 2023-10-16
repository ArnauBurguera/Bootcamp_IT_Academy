package BurgueraCallesArnau.s05t01n01.controllers;

import BurgueraCallesArnau.s05t01n01.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n01.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class RESTfulSucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    public ResponseEntity<Sucursal> createSucursal(@RequestParam Sucursal sucursal){
        Sucursal sucursalCreated = sucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(sucursalCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SucursalDTO> updateSucursal(@RequestBody SucursalDTO sucursalDTO){
        SucursalDTO sucursalUpdated = sucursalService.updateSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Integer id){
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getOneSucursal(@PathVariable Integer id){
        SucursalDTO sucursalDTO = sucursalService.getOneSucursal(id);
        return  new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals(){
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
}

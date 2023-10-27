package BurgueraCallesArnau.s05t01n02.controllers;

import BurgueraCallesArnau.s05t01n02.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n02.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n02.model.services.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
@Tag(name = "Sucursal Management", description = "Operations pertaining to Sucursal Management")
public class RESTfulSucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    @Operation(summary = "Create a new Sucursal", description = "This API allows you to create a new Sucursal.")
    public ResponseEntity<Sucursal> createSucursal(@Parameter(description = "The Sucursal object to be created", required = true) @RequestParam Sucursal sucursal) {
        Sucursal sucursalCreated = sucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(sucursalCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Update a Sucursal", description = "This API allows you to update an existing Sucursal.")
    public ResponseEntity<SucursalDTO> updateSucursal(@Parameter(description = "The updated Sucursal object", required = true) @RequestBody Sucursal sucursal) {
        SucursalDTO sucursalUpdated = sucursalService.updateSucursal(sucursal);
        return new ResponseEntity<>(sucursalUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a Sucursal by ID", description = "This API allows you to delete a Sucursal by its ID.")
    public ResponseEntity<Void> deleteSucursal(@Parameter(description = "The ID of the Sucursal to be deleted", required = true) @PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    @Operation(summary = "Get a specific Sucursal by ID", description = "This API allows you to retrieve a specific Sucursal by its ID.")
    public ResponseEntity<SucursalDTO> getOneSucursal(@Parameter(description = "The ID of the Sucursal to retrieve", required = true) @PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getOneSucursal(id);
        return new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all Sucursals", description = "This API allows you to retrieve a list of all Sucursals.")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals() {
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
}

package BurgueraCallesArnau.s05t01n02.controllers;

import BurgueraCallesArnau.s05t01n02.model.domain.Sucursal;
import BurgueraCallesArnau.s05t01n02.model.dto.SucursalDTO;
import BurgueraCallesArnau.s05t01n02.model.services.SucursalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
@Api(value = "Sucursal Management", tags = "Operations pertaining to Sucursal Management")
public class RESTfulSucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping("/add")
    @ApiOperation(value = "Create a new Sucursal", notes = "This API allows you to create a new Sucursal.")
    public ResponseEntity<Sucursal> createSucursal(@ApiParam(value = "The Sucursal object to be created", required = true) @RequestParam Sucursal sucursal) {
        Sucursal sucursalCreated = sucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(sucursalCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a Sucursal", notes = "This API allows you to update an existing Sucursal.")
    public ResponseEntity<SucursalDTO> updateSucursal(@ApiParam(value = "The updated Sucursal object", required = true) @RequestBody Sucursal sucursal) {
        SucursalDTO sucursalUpdated = sucursalService.updateSucursal(sucursal);
        return new ResponseEntity<>(sucursalUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a Sucursal by ID", notes = "This API allows you to delete a Sucursal by its ID.")
    public ResponseEntity<Void> deleteSucursal(@ApiParam(value = "The ID of the Sucursal to be deleted", required = true) @PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    @ApiOperation(value = "Get a specific Sucursal by ID", notes = "This API allows you to retrieve a specific Sucursal by its ID.")
    public ResponseEntity<SucursalDTO> getOneSucursal(@ApiParam(value = "The ID of the Sucursal to retrieve", required = true) @PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getOneSucursal(id);
        return new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all Sucursals", notes = "This API allows you to retrieve a list of all Sucursals.")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals() {
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        return new ResponseEntity<>(sucursals, HttpStatus.OK);
    }
}

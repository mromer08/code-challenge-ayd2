package com.ayd2.spring_challenge.controllers.driver;

import java.net.URI;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ayd2.spring_challenge.dto.drivers.*;
import com.ayd2.spring_challenge.exceptions.DuplicatedEntityException;
import com.ayd2.spring_challenge.exceptions.NotFoundException;
import com.ayd2.spring_challenge.services.drivers.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     * Obtener todos los conductores
     */
    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> getAllDrivers() {
        return ResponseEntity.ok(driverService.findAll());
    }

    /**
     * Obtener un conductor por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> getDriverById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(driverService.findById(id));
    }

    /**
     * Crear un nuevo conductor
     */
    @PostMapping
    public ResponseEntity<DriverResponseDTO> createDriver(@RequestBody NewDriverRequestDTO dto) throws DuplicatedEntityException {
        DriverResponseDTO createdDriver = driverService.create(dto);
        return ResponseEntity.created(URI.create("/drivers/" + createdDriver.id())).body(createdDriver);
    }

    /**
     * Actualizar un conductor
     */
    @PutMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> updateDriver(@PathVariable Long id, @RequestBody UpdateDriverRequestDTO dto) throws NotFoundException {
        return ResponseEntity.ok(driverService.update(id, dto));
    }

    /**
     * Eliminar un conductor
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) throws NotFoundException {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


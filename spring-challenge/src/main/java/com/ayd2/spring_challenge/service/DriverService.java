package com.ayd2.spring_challenge.service;

import org.springframework.stereotype.Service;

import com.ayd2.spring_challenge.model.Driver;
import com.ayd2.spring_challenge.repository.DriverRepository;

import jakarta.transaction.Transactional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Transactional
    public Driver createDriver(Driver driver) {
        if (driverRepository.findByName(driver.getName()).isPresent()) {
            throw new IllegalArgumentException("Driver with this name already exists");
        }
        return driverRepository.save(driver);
    }
    
}

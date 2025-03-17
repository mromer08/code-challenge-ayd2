package com.ayd2.spring_challenge.services.drivers;

import java.util.List;

import com.ayd2.spring_challenge.dto.drivers.DriverResponseDTO;
import com.ayd2.spring_challenge.dto.drivers.NewDriverRequestDTO;
import com.ayd2.spring_challenge.dto.drivers.UpdateDriverRequestDTO;
import com.ayd2.spring_challenge.exceptions.DuplicatedEntityException;

public interface DriverService {
    DriverResponseDTO create(NewDriverRequestDTO driver) throws DuplicatedEntityException;
    List<DriverResponseDTO> findAll();
    DriverResponseDTO findById(Long id);
    DriverResponseDTO update(Long id, UpdateDriverRequestDTO driver);
    void delete(Long id);
}

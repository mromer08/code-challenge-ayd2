package com.ayd2.spring_challenge.services.drivers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ayd2.spring_challenge.dto.drivers.*;
import com.ayd2.spring_challenge.exceptions.*;
import com.ayd2.spring_challenge.mappers.driver.DriverMapper;
import com.ayd2.spring_challenge.models.driver.Driver;
import com.ayd2.spring_challenge.repositories.driver.DriverRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper = DriverMapper.INSTANCE;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverResponseDTO create(NewDriverRequestDTO dto) throws DuplicatedEntityException {
        if (driverRepository.existsByName(dto.name())) {
            throw new DuplicatedEntityException(
                String.format("A driver with name '%s' already exists.", dto.name())
            );
        }
        Driver driver = driverMapper.newDriverRequestDTOToDriver(dto);
        driver = driverRepository.save(driver);
        return driverMapper.driverToDriverResponseDTO(driver);
    }
    

    @Override
    public List<DriverResponseDTO> findAll() {
        return driverRepository.findAll().stream()
                .map(driverMapper::driverToDriverResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DriverResponseDTO findById(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Driver with ID %d not found.", id)));
        return driverMapper.driverToDriverResponseDTO(driver);
    }
    
    @Override
    public DriverResponseDTO update(Long id, UpdateDriverRequestDTO dto) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Driver with ID %d not found.", id)));
        driverMapper.updateDriverFromDTO(dto, driver);
        driver = driverRepository.save(driver);
        return driverMapper.driverToDriverResponseDTO(driver);
    }
    
    @Override
    public void delete(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new NotFoundException(String.format("Driver with ID %d not found.", id));
        }
        driverRepository.deleteById(id);
    }
    
}
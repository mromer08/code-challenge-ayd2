package com.ayd2.spring_challenge.mappers.driver;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.ayd2.spring_challenge.dto.drivers.DriverResponseDTO;
import com.ayd2.spring_challenge.dto.drivers.NewDriverRequestDTO;
import com.ayd2.spring_challenge.dto.drivers.UpdateDriverRequestDTO;
import com.ayd2.spring_challenge.models.driver.Driver;

@Mapper
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverResponseDTO driverToDriverResponseDTO(Driver driver);
    
    @Mapping(target = "id", ignore = true)
    Driver newDriverRequestDTOToDriver(NewDriverRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateDriverFromDTO(UpdateDriverRequestDTO dto, @MappingTarget Driver driver);

}

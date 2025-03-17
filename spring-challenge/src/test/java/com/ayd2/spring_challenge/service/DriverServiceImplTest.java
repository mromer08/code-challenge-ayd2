package com.ayd2.spring_challenge.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ayd2.spring_challenge.dto.drivers.DriverResponseDTO;
import com.ayd2.spring_challenge.dto.drivers.NewDriverRequestDTO;
import com.ayd2.spring_challenge.dto.drivers.UpdateDriverRequestDTO;
import com.ayd2.spring_challenge.mappers.driver.DriverMapper;
import com.ayd2.spring_challenge.models.driver.Driver;
import com.ayd2.spring_challenge.repositories.driver.DriverRepository;
import com.ayd2.spring_challenge.services.drivers.DriverServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DriverServiceImplTest {
    // utilizar constantes para los valores de los atributos a testear
    private static final Long DRIVER_ID = 1L;
    private static final String DRIVER_NAME = "John Doe";
    private static final int DRIVER_AGE = 30;
    
    private static final Long DRIVER2_ID = 2L;
    private static final String DRIVER2_NAME = "Bob";
    private static final int DRIVER2_AGE = 35;

    @Mock
    DriverRepository driverRepository;
    
    @Mock
    DriverMapper driverMapper;

    @InjectMocks
    DriverServiceImpl serviceToTest;

    private Driver driver;
    private DriverResponseDTO driverResponse;
    private NewDriverRequestDTO newDriverDTO;
    private UpdateDriverRequestDTO updateDriverDTO;

    @BeforeEach
    void setUp() {
        driver = new Driver();
        driver.setId(DRIVER_ID);
        driver.setName(DRIVER_NAME);
        driver.setAge(DRIVER_AGE);

        driverResponse = new DriverResponseDTO(DRIVER_ID, DRIVER_NAME, DRIVER_AGE);
        newDriverDTO = new NewDriverRequestDTO(DRIVER_NAME, DRIVER_AGE);
        updateDriverDTO = new UpdateDriverRequestDTO(DRIVER_NAME, DRIVER2_AGE);
    }
    
    @Test
    void testCreateDriverWhenNameNotDuplicated() throws Exception {
        // arrange
        // Vale la pena hacer un mock del dto si no tiene muchos atributos

        ArgumentCaptor<Driver> driverCaptor = ArgumentCaptor.forClass(Driver.class);

        when(driverRepository.existsByName(DRIVER_NAME)).thenReturn(false);
        when(driverRepository.save(driverCaptor.capture())).thenReturn(driver);

        // act
        DriverResponseDTO result = serviceToTest.create(newDriverDTO);

        // assert
        // casi no usar el veify, en su lugar comparar valores concretos
        // verify(driverRepository, times(1)).save(any(Driver.class));
        // es mejor que las funciones retornen  algo en lugar de usar void()
        // no es bueno hacer un assertequals, es mejor un assertAll
        assertAll(
            () -> assertEquals(DRIVER_NAME, driverCaptor.getValue().getName()),
            () -> assertEquals(DRIVER_AGE, driverCaptor.getValue().getAge()),
            () -> assertNotNull(result),
            () -> assertEquals(DRIVER_NAME, result.name()),
            () -> assertEquals(DRIVER_AGE, result.age())
        );
    }

}
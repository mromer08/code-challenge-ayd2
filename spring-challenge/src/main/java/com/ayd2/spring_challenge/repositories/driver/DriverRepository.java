package com.ayd2.spring_challenge.repositories.driver;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayd2.spring_challenge.models.driver.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
    boolean existsByName(String name);
    // boolean exisexistsByNameAndNotId(String name, Long id);
    // boolean exisexistsByNameAndIdNotEquals(String name, Long id);
    // buscar
}

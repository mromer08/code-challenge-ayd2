package com.ayd2.spring_challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayd2.spring_challenge.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
    Optional<Driver> findByName(String name);
}

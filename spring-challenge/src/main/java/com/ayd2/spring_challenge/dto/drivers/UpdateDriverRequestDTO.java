package com.ayd2.spring_challenge.dto.drivers;

import jakarta.validation.constraints.Min;

public record UpdateDriverRequestDTO (
    String name,
    
    @Min(value = 18, message = "Driver must be at least 18 years old")
    Integer age
) {}

package com.ayd2.spring_challenge.dto.drivers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewDriverRequestDTO(
    
    @NotBlank(message = "Driver name is required")
    String name,

    @NotNull(message = "Driver age is required")
    @Min(value = 18, message = "Driver must be at least 18 years old")
    int age
) {};
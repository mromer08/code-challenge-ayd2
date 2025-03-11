package com.ayd2.spring_challenge.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    
    @NotBlank(message = "Driver name is required")
    private String name;

    @NotBlank(message = "Age driver is required")
    private int age;
    

}

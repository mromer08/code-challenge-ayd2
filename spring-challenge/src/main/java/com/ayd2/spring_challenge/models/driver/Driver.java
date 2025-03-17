package com.ayd2.spring_challenge.models.driver;

import jakarta.persistence.*;
import lombok.*;

// como buena practica deben de implementarse Equals y HashCode
// normalmente esta basada en la llave primaria (el id en este caso)
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;
    
}
package com.keyin.airportapi.airport;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToMany(mappedBy = "airports")
    private Set<Aircraft> aircraft;

    // Getters and Setters
}


package com.keyin.airportapi.repository;

import com.keyin.airportapi.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}


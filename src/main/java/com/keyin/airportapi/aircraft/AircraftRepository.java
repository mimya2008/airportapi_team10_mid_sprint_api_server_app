package com.keyin.airportapi.aircraft;

import com.keyin.airportapi.airport.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}


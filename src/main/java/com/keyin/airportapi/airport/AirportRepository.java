package com.keyin.airportapi.airport;

import com.keyin.airportapi.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}


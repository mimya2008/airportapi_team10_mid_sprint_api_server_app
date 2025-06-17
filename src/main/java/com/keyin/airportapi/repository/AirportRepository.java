package com.keyin.airportapi.repository;

import com.keyin.airportapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}


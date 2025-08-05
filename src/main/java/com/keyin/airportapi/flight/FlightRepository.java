package com.keyin.airportapi.flight;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByArrivalAirportId(Long airportId);
    List<Flight> findByDepartureAirportId(Long airportId);
}


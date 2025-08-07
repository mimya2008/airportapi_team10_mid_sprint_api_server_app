package com.keyin.airportapi.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAllByCity_Name(String name);
    Optional<Airport> findByName(String name);
}

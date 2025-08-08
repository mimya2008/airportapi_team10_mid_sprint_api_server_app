package com.keyin.airportapi.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }

    @GetMapping("/arrivals")
    public ResponseEntity<List<Flight>> getArrivals(@RequestParam String airportName) {
        return ResponseEntity.ok(flightService.getArrivalsByAirportName(airportName));
    }

    @GetMapping("/departures")
    public ResponseEntity<List<Flight>> getDepartures(@RequestParam String airportName) {
        return ResponseEntity.ok(flightService.getDeparturesByAirportName(airportName));
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

}


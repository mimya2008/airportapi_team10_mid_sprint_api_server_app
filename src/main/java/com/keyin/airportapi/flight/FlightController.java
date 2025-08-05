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
    public ResponseEntity<List<Flight>> getArrivals(@RequestParam Long airportId) {
        return ResponseEntity.ok(flightService.getArrivalsByAirportId(airportId));
    }

    @GetMapping("/departures")
    public ResponseEntity<List<Flight>> getDepartures(@RequestParam Long airportId) {
        return ResponseEntity.ok(flightService.getDeparturesByAirportId(airportId));
    }
}


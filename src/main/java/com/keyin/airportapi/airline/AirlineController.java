package com.keyin.airportapi.airline;

import com.keyin.airportapi.airline.Airline;
import com.keyin.airportapi.airline.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @PostMapping
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) {
        return ResponseEntity.ok(airlineService.addAirline(airline));
    }

    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines() {
        return ResponseEntity.ok(airlineService.getAllAirlines());
    }
}

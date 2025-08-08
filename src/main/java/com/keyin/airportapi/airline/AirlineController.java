package com.keyin.airportapi.airline;

import com.keyin.airportapi.airline.Airline;
import com.keyin.airportapi.airline.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@CrossOrigin
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

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
        Airline updated = airlineService.updateAirline(id, airline);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }
}

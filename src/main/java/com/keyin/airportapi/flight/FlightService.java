package com.keyin.airportapi.flight;
 import com.keyin.airportapi.aircraft.Aircraft;
 import com.keyin.airportapi.aircraft.AircraftRepository;
 import com.keyin.airportapi.airline.Airline;
 import com.keyin.airportapi.airline.AirlineRepository;
 import com.keyin.airportapi.airport.Airport;
 import com.keyin.airportapi.airport.AirportRepository;
 import jakarta.persistence.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    public Flight addFlight(Flight flight) {
        Airport departure = airportRepository.findById(flight.getDepartureAirport().getId())
                .orElseThrow(() -> new RuntimeException("Departure airport not found"));

        Airport arrival = airportRepository.findById(flight.getArrivalAirport().getId())
                .orElseThrow(() -> new RuntimeException("Arrival airport not found"));

        Airline airline = airlineRepository.findById(flight.getAirline().getId())
                .orElseThrow(() -> new RuntimeException("Airline not found"));

        Aircraft aircraft = aircraftRepository.findById(flight.getAircraft().getId())
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        // Set full entities
        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setAirline(airline);
        flight.setAircraft(aircraft);

        return flightRepository.save(flight);
    }
}


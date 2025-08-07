package com.keyin.airportapi.flight;
 import com.keyin.airportapi.aircraft.Aircraft;
 import com.keyin.airportapi.aircraft.AircraftRepository;
 import com.keyin.airportapi.airline.Airline;
 import com.keyin.airportapi.airline.AirlineRepository;
 import com.keyin.airportapi.airport.Airport;
 import com.keyin.airportapi.airport.AirportRepository;
 import jakarta.persistence.*;
 import java.util.List;
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
        Airport departure = airportRepository.findByName(flight.getDepartureAirport().getName())
                .orElseThrow(() -> new RuntimeException("Departure airport not found"));

        Airport arrival = airportRepository.findByName(flight.getArrivalAirport().getName())
                .orElseThrow(() -> new RuntimeException("Arrival airport not found"));

        Airline airline = airlineRepository.findByName(flight.getAirline().getName())
                .orElseThrow(() -> new RuntimeException("Airline not found"));

        Aircraft aircraft = aircraftRepository.findByType(flight.getAircraft().getType())
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setAirline(airline);
        flight.setAircraft(aircraft);

        return flightRepository.save(flight);
    }
    public List<Flight> getArrivalsByAirportName(String name) {
        return flightRepository.findByArrivalAirport_Name(name);
    }

    public List<Flight> getDeparturesByAirportName(String name) {
        return flightRepository.findByDepartureAirport_Name(name);
    }

}


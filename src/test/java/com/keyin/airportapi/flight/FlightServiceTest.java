package com.keyin.airportapi.flight;

import com.keyin.airportapi.aircraft.Aircraft;
import com.keyin.airportapi.aircraft.AircraftRepository;
import com.keyin.airportapi.airline.Airline;
import com.keyin.airportapi.airline.AirlineRepository;
import com.keyin.airportapi.airport.Airport;
import com.keyin.airportapi.airport.AirportRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private AirlineRepository airlineRepository;

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private FlightService flightService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFlight() {
        Airport departure = new Airport();
        departure.setName("YYT");

        Airport arrival = new Airport();
        arrival.setName("YYZ");

        Airline airline = new Airline();
        airline.setName("Air Canada");

        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 737");

        Flight flight = new Flight();
        flight.setFlightNumber("AC123");
        flight.setGate("A1");
        flight.setFromLocation("St. John's");
        flight.setDestination("Toronto");
        flight.setScheduledDateTime(LocalDateTime.now());

        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setAirline(airline);
        flight.setAircraft(aircraft);

        when(airportRepository.findByName("YYT")).thenReturn(Optional.of(departure));
        when(airportRepository.findByName("YYZ")).thenReturn(Optional.of(arrival));
        when(airlineRepository.findByName("Air Canada")).thenReturn(Optional.of(airline));
        when(aircraftRepository.findByType("Boeing 737")).thenReturn(Optional.of(aircraft));
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight saved = flightService.addFlight(flight);
        assertEquals("AC123", saved.getFlightNumber());
    }
}


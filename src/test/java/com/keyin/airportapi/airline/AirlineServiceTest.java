package com.keyin.airportapi.airline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AirlineServiceTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineService airlineService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAirline() {
        Airline airline = new Airline();
        airline.setName("Air Canada");

        when(airlineRepository.save(airline)).thenReturn(airline);

        Airline result = airlineService.addAirline(airline);
        assertEquals("Air Canada", result.getName());
    }

    @Test
    public void testGetAllAirlines() {
        List<Airline> airlineList = new ArrayList<>();
        airlineList.add(new Airline());

        when(airlineRepository.findAll()).thenReturn(airlineList);

        List<Airline> result = airlineService.getAllAirlines();
        assertEquals(1, result.size());
    }
}


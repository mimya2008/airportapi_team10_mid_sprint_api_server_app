package com.keyin.airportapi.airport;

import com.keyin.airportapi.city.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAirport() {
        City city = new City();
        city.setId(1L);
        city.setName("Toronto");

        Airport airport = new Airport();
        airport.setName("YYZ");
        airport.setCode("Toronto");
        airport.setCity(city);

        when(airportRepository.save(airport)).thenReturn(airport);

        Airport result = airportService.createAirport(airport);
        assertEquals("YYZ", result.getName());
    }

    @Test
    public void testGetAirportById() {
        Airport airport = new Airport();
        airport.setId(1L);
        airport.setName("YYT");

        when(airportRepository.findById(1L)).thenReturn(Optional.of(airport));

        Airport result = airportService.getAirportById(1L);
        assertEquals("YYT", result.getName());
    }
}


package com.keyin.airportapi.aircraft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AircraftServiceTest {

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private AircraftService aircraftService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAircraft() {
        Aircraft aircraft = new Aircraft();
        aircraft.setType("Boeing 737");

        when(aircraftRepository.save(aircraft)).thenReturn(aircraft);

        Aircraft result = aircraftService.createAircraft(aircraft);
        assertEquals("Boeing 737", result.getType());
    }

    @Test
    public void testGetAircraftById() {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(1L);
        aircraft.setType("Boeing 737");

        when(aircraftRepository.findById(1L)).thenReturn(Optional.of(aircraft));

        Aircraft result = aircraftService.getAircraftById(1L);
        assertNotNull(result);
        assertEquals("Boeing 737", result.getType());
    }

    @Test
    public void testDeleteAircraft() {
        doNothing().when(aircraftRepository).deleteById(1L);
        aircraftService.deleteAircraft(1L);
        verify(aircraftRepository, times(1)).deleteById(1L);
    }
}


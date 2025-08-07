package com.keyin.airportapi.passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerService passengerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePassenger() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Alice");

        when(passengerRepository.save(passenger)).thenReturn(passenger);

        Passenger result = passengerService.createPassenger(passenger);
        assertEquals("Alice", result.getFirstName());
    }

    @Test
    public void testGetPassengerById() {
        Passenger passenger = new Passenger();
        passenger.setId(1L);
        passenger.setFirstName("Alice");

        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));

        Passenger result = passengerService.getPassengerById(1L);
        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
    }

    @Test
    public void testDeletePassenger() {
        doNothing().when(passengerRepository).deleteById(1L);
        passengerService.deletePassenger(1L);
        verify(passengerRepository, times(1)).deleteById(1L);
    }
}

package com.keyin.airportapi.city;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    public CityServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCity() {
        City city = new City();
        city.setName("St. John's");
        city.setState("NL");
        city.setPopulation(200000);

        when(cityRepository.save(city)).thenReturn(city);

        City result = cityService.createCity(city);
        assertEquals("St. John's", result.getName());
    }

    @Test
    public void testGetCityById() {
        City city = new City();
        city.setId(1L);
        city.setName("St. John's");

        when(cityRepository.findById(1L)).thenReturn(Optional.of(city));

        City result = cityService.getCityById(1L);
        assertEquals("St. John's", result.getName());
    }
}


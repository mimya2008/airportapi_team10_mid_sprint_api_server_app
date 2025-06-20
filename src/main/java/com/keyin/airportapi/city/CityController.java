package com.keyin.airportapi.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityService.getCityById(id);
        return (city != null) ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        City updated = cityService.updateCity(id, city);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}


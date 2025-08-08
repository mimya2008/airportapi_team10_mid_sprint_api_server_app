package com.keyin.airportapi.airline;

import com.keyin.airportapi.airline.Airline;
import com.keyin.airportapi.airline.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline updateAirline(Long id, Airline updatedAirline) {
        Optional<Airline> existingAirlineOpt = airlineRepository.findById(id);
        if (existingAirlineOpt.isPresent()) {
            Airline existingAirline = existingAirlineOpt.get();
            existingAirline.setName(updatedAirline.getName());
            existingAirline.setCountry(updatedAirline.getCountry());
            return airlineRepository.save(existingAirline);
        } else {
            return null;
        }
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}

package com.keyin.airportapi.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);
        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            aircraft.setType(updatedAircraft.getType());
            aircraft.setAirlineName(updatedAircraft.getAirlineName());
            aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
            aircraft.setAirports(updatedAircraft.getAirports());

            return aircraftRepository.save(aircraft);
        }
        return null;
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }
}


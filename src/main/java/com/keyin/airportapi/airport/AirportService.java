package com.keyin.airportapi.airport;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        Airport airport = getAirportById(id);
        if (airport != null) {
            airport.setName(updatedAirport.getName());
            airport.setCode(updatedAirport.getCode());
            // Add any other updates
            return airportRepository.save(airport);
        }
        return null;
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}

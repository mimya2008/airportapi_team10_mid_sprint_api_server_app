package com.keyin.airportapi.city;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keyin.airportapi.airport.Airport;
import com.keyin.airportapi.passenger.Passenger;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private int population;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "city-airport")
    private Set<Airport> airports;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "city-passenger")
    private Set<Passenger> passengers;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public Set<Airport> getAirports() { return airports; }
    public void setAirports(Set<Airport> airports) { this.airports = airports; }

    public Set<Passenger> getPassengers() { return passengers; }
    public void setPassengers(Set<Passenger> passengers) { this.passengers = passengers; }
}

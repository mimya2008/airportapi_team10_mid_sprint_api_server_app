package com.keyin.airportapi.flight;

import com.keyin.airportapi.aircraft.Aircraft;
import com.keyin.airportapi.airline.Airline;
import com.keyin.airportapi.airport.Airport;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;

    private String gate;
    private String fromLocation;
    private String destination;

    private LocalDateTime scheduledDateTime;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getGate() {
        return gate;
    }
    public void setGate(String gate) {
        this.gate = gate;
    }
    public String getFromLocation() {
        return fromLocation;
    }
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }
    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }
    public Airport getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    public Airline getAirline() {
        return airline;
    }
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}

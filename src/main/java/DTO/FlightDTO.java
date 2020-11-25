/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Flight;
import java.sql.Date;

/**
 *
 * @author rh
 */
public class FlightDTO {
    
    private int flightId;
    private Date departure;
    private Date arrival;
    private String destinationAirport;
    private String takeoffAirport;
    private int price;

    public FlightDTO(Flight flight) {
        this.flightId = flight.getFlightId();
        this.departure = flight.getDeparture();
        this.arrival = flight.getArrival();
        this.destinationAirport = flight.getDestinationAirport().getAirportName();
        this.takeoffAirport = flight.getTakeoffAirport().getAirportName();
        this.price = flight.getPrice();
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getTakeoffAirport() {
        return takeoffAirport;
    }

    public void setTakeoffAirport(String takeoffAirport) {
        this.takeoffAirport = takeoffAirport;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    
    
   
    
    
    
}

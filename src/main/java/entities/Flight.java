/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rh
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    private Date departure;
    private Date arrival;
    private Airport destinationAirport;
    private Airport takeoffAirport;
    private int price;

    public Flight(int flightId, Date departure, Date arrival, Airport destinationAirport, Airport takeoffAirport, int price) {
        this.flightId = flightId;
        this.departure = departure;
        this.arrival = arrival;
        this.destinationAirport = destinationAirport;
        this.takeoffAirport = takeoffAirport;
        this.price = price;
    }

    public Flight(Date departure, Date arrival, Airport destinationAirport, Airport takeoffAirport, int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.destinationAirport = destinationAirport;
        this.takeoffAirport = takeoffAirport;
        this.price = price;
    }

    public Flight() {
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

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getTakeoffAirport() {
        return takeoffAirport;
    }

    public void setTakeoffAirport(Airport takeoffAirport) {
        this.takeoffAirport = takeoffAirport;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   

  

    
    
    
}

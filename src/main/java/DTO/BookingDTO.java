/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Booking;
import entities.Flight;
import entities.Passenger;
import java.util.Date;

/**
 *
 * @author abed
 */
public class BookingDTO {
    private int flightId;
    private Date departure;
    private Date arrival;
    private String destinationAirport;
    private String takeoffAirport;
    private int price;
    
    private int passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    public BookingDTO(Booking b) {
        this.flightId = b.getFlight().getFlightId();
        this.departure = b.getFlight().getDeparture();
        this.arrival = b.getFlight().getArrival();
        this.destinationAirport = b.getFlight().getDestinationAirport().getAirportName();
        this.takeoffAirport = b.getFlight().getTakeoffAirport().getAirportName();
        this.price = b.getFlight().getPrice();
        this.passengerId = b.getPassengerInfo().getId();
        this.firstName = b.getPassengerInfo().getFirstName();
        this.lastName = b.getPassengerInfo().getLastName();
        this.email = b.getPassengerInfo().getEmail();
        this.phoneNumber = b.getPassengerInfo().getPhoneNumber();
    }
     
    
}

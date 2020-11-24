/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.demo;

import entities.Airport;
import entities.Flight;

/**
 *
 * @author rh
 */
public class FlightDTO {
    
    private String airline;
    private String des;
    private String arival;
    private int price;

    public FlightDTO(Flight flight) {
        this.airline = flight.getAirline();
        this.des = flight.getDes().getName();
        this.arival = flight.getArival().getName();
        this.price = flight.getPrice();
    }
    
    
    
}
